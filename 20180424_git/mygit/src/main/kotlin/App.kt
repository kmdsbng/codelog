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
}