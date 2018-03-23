
fun main(argv: Array<String>) {
    val list = listOf("1", "2", "3", "4")
    val numList = listOf(1, 2, 3, 4)

    println(
            myMap(list) { it + it }
    )

    println(
            myFilter(list) { it.toInt() % 2 == 0 }
    )

    println(
            myMaxBy(numList) { - it }
    )

    println(
            myMaxBy(numList) { it }
    )
}


fun myMaxBy(src: List<Int>, cb: (Int) -> Int): Int? {
    var result : Int? = null
    for (s in src) {
        if (result == null) {
            result = s
        } else {
            if (cb(result) < cb(s)) {
                result = s
            }
        }
    }
    return result
}

fun <T> myFilter(src: List<T>, cb: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (s in src) {
        if (cb(s)) {
            result.add(s)
        }
    }
    return result
}


fun <T> myMap(src: List<T>, cb: (T) -> T): List<T> {
    val result = mutableListOf<T>()
    for (s in src) {
        result.add(cb(s))
    }
    return result
}



