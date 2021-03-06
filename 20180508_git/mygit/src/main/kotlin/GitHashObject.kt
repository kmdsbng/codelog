import java.io.FileInputStream
import java.security.MessageDigest
import kotlin.system.exitProcess


// ファイルからデータを読み込み、ハッシュ値を返す
fun main(argv: Array<String>) {
    if (argv.size == 0) {
        println("Please set file path to parameter")
        exitProcess(1)
    }
    val objectPath = argv[0]
    val input = FileInputStream(objectPath)

    try {
        val content = readFile(input)
        val blobData = createBlobData(content)
        val sha1Hash = calcSha1Hash(blobData)
        println(sha1Hash.toHex())
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


