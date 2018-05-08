import java.io.FileInputStream
import java.io.InputStream
import java.util.zip.InflaterInputStream
import kotlin.system.exitProcess


// 標準入力からデータを読み込み、ハッシュ値を返す
fun main(argv: Array<String>) {
    val input = System.`in`

    //val stream = FileInputStream(objectPath)

    try {
        decompress(stream) {readBytes: ByteArray, offset: Int, len: Int ->
            System.out.write(readBytes, offset, len)
        }
    } finally {
        stream.close()
    }
}

class HeaderOffsetCalculator {
    var headerEndFound: Boolean = false

    fun getHeaderOffset(bytes: ByteArray, len: Int): Int {
        if (headerEndFound)
            return 0

        var offset: Int = 0
        val endDelimiter: Byte = 0

        while (offset < len) {
            if (bytes[offset] == endDelimiter) {
                headerEndFound = true
                offset += 1
                break
            }

            offset += 1
        }

        return offset
    }
}

fun decompress(stream: InputStream, cb: (ByteArray, Int, Int) -> Unit) {

    val inflaterIs = InflaterInputStream(stream)
    val headerOffsetCalculator = HeaderOffsetCalculator()

    val b = ByteArray(1024)
    while (true) {
        val len = inflaterIs.read(b)
        if (len == -1)
            break

        val headerOffset = headerOffsetCalculator.getHeaderOffset(b, len)
        cb(b, headerOffset, len - headerOffset)
    }
}
