import java.io.FileInputStream
import java.security.MessageDigest
import java.util.zip.Deflater
import java.util.zip.DeflaterInputStream
import java.util.zip.DeflaterOutputStream
import kotlin.system.exitProcess


// ファイルからデータを読み込み、gitリポジトリに書き込む
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

        compress(blobData) { bytes: ByteArray, len: Int ->
            System.out.write(bytes, 0, len)
        }
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

//class HeaderOffsetCalculator {
//    var headerEndFound: Boolean = false
//
//    fun getHeaderOffset(bytes: ByteArray, len: Int): Int { //        if (headerEndFound)
//            return 0
//
//        var offset: Int = 0
//        val endDelimiter: Byte = 0
//
//        while (offset < len) {
//            if (bytes[offset] == endDelimiter) {
//                headerEndFound = true
//                offset += 1
//                break
//            }
//
//            offset += 1
//        }
//
//        return offset
//    }
//}
//
fun compress(data: ByteArray, cb: (bytes: ByteArray, len: Int) -> Unit) {
//fun decompress(stream: InputStream, cb: (ByteArray, Int, Int) -> Unit) {

    val complessor = Deflater()
    complessor.setInput(data)
    complessor.finish()

    val bytes = ByteArray(3)
    complessor.deflate(bytes)

    while (!complessor.finished()) {
        val len = complessor.deflate(bytes)
        cb(bytes, len)
    }
    complessor.end()
}


