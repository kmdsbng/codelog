import java.io.File
import kotlin.system.exitProcess

fun main(argv: Array<String>) {
    if (argv.size == 0) {
        println("Please set object file path to parameter")
        exitProcess(1)
    }
    val objectPath = argv[0]
    println(objectPath)

    val src = File(objectPath).absoluteFile
    val stream = src.inputStream()

    val b = ByteArray(1024)
    while (true) {
        val len = stream.read(b)
        if (len == -1)
            break

        System.out.write(b, 0, len)
    }
}