import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.security.InvalidParameterException
import java.security.MessageDigest
import java.util.zip.Deflater
import kotlin.system.exitProcess

data class Sha1Hash(
        val valueOrg: String
) {
    val value = valueOrg.toLowerCase()
    init {
        if (value.length != 40) {
            throw InvalidParameterException("Invalid sha1 hash length: ${value}")
        }
    }
}

data class ObjectPath(
        val repoPathOrg: String,
        val hash: Sha1Hash
) {
    val dirName = hash.value.slice(0..1)
    val fileName = hash.value.slice(2..(hash.value.length - 1))
    val repoPath = if (repoPathOrg[repoPathOrg.length - 1] == '/') {
        repoPathOrg.slice(0..(repoPathOrg.length - 2))
    } else {
        repoPathOrg
    }

    init {
        if (repoPath.endsWith(".git") == false) {
            throw InvalidParameterException("Repository directory is not .git: ${repoPath}")
        }
    }

    fun getDirPath(): String {
        return "${repoPath}/objects/${dirName}"
    }

    fun getObjectPath(): String {
        return "${repoPath}/objects/${dirName}/${fileName}"
    }
}

// ファイルからデータを読み込み、gitリポジトリに書き込む
fun main(argv: Array<String>) {
    if (argv.size < 2) {
        println("Please set input / git repo path to parameter")
        exitProcess(1)
    }
    val inputPath = argv[0]
    val repoPath = argv[1]
    val input = FileInputStream(inputPath)

    try {
        val content = readFile(input)
        val blobData = createBlobData(content)
        val sha1Hash = calcSha1Hash(blobData)
        val objectPath = ObjectPath(repoPath, Sha1Hash(sha1Hash.toHex()))
        println(objectPath.repoPath)
        println(objectPath.getDirPath())
        println(objectPath.getObjectPath())

        File(objectPath.getDirPath()).mkdirs()
        val outputFile = File(objectPath.getObjectPath())
        outputFile.setWritable(true)
        val output = FileOutputStream(objectPath.getObjectPath())
        try {
            compress(blobData) { bytes: ByteArray, len: Int ->
                output.write(bytes, 0, len)
            }
        } finally {
            output.close()
        }
        outputFile.setWritable(false)
    } finally {
        input.close()
    }
}

private fun calcSha1Hash(blobData: ByteArray): ByteArray {
    val algorithm = "SHA-1"
    return MessageDigest.getInstance(algorithm).digest(blobData)
}

private fun createBlobData(content: ByteArray): ByteArray {
    val blobHeader = "blob ${content.size}".toByteArray()
    val blobDelimiter = byteArrayOf(0)
    val blobData = listOf(
            blobHeader,
            blobDelimiter,
            content
    ).flatMap { it.toList() }.toByteArray()
    return blobData
}

private fun readFile(input: FileInputStream): ByteArray {
    val bs = mutableListOf<ByteArray>()
    val b = ByteArray(3)
    while (true) {
        val len = input.read(b)
        if (len == -1)
            break

        bs.add(b.copyOf(len))
    }

    val content = bs.flatMap { it.toList() }.toByteArray()
    return content
}

private val HEX_CHARS = "0123456789ABCDEF".toCharArray()

private fun ByteArray.toHex() : String{
    val result = StringBuffer()

    forEach {
        val octet = it.toInt()
        val firstIndex = (octet and 0xF0).ushr(4)
        val secondIndex = octet and 0x0F
        result.append(HEX_CHARS[firstIndex])
        result.append(HEX_CHARS[secondIndex])
    }

    return result.toString()
}

fun compress(data: ByteArray, cb: (bytes: ByteArray, len: Int) -> Unit) {
    val deflater = Deflater()
    deflater.setInput(data)
    deflater.finish()

    val bytes = ByteArray(1024)
    while (!deflater.finished()) {
        val len = deflater.deflate(bytes)
        cb(bytes, len)
    }
    deflater.end()
}


