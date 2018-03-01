
fun main(argv: Array<String>) {

    val result = double(3, 5, 7)
    result.forEach {
        println(it)
    }

}

fun double(vararg items: Int): List<Int> {
    return items.map { it * it }
}
