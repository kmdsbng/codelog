



fun main(argv: Array<String>) {
    val list = listOf("1", "2", "3", "4")
    val numList = listOf(1, 2, 3, 4)

    val list2: List<String> = list

    //println(
    //        list.map {it + it}
    //)

    //fun doubleStr(str: String): String {
    //    return str + str
    //}

    //println(
    //        myMap1(list, ::doubleStr)
    //)

    //println(
    //        myMap1(list) { it + it }
    //)

    println(
            myMap2(list) { it + it }
    )

    //println(
    //        myFilter(list) { it.toInt() % 2 == 0 }
    //)

    //println(
    //        myFilter1(list) { it.toInt() % 2 == 0 }
    //)

    //println(
    //        myMaxBy(numList) { - it }
    //)

    //println(
    //        myMaxBy(numList) { it }
    //)

    //myEachSlice(list10, 3) {
    //    println(it)
    //}

    //println(
    //        list.myMap3 { it + it + it }
    //)

    //println(
    //        list.myMap4 { it + "ite" }
    //)

    //println(
    //        list.reversed()
    //)

    //println(
    //        numList.partition {
    //            it < 2
    //        }
    //)

    //println(
    //        numList.reject {
    //            it < 2
    //        }
    //)

    //println(numList.sum())

    //println(numList.take(2))

    //println(numList.toHashSet())

    //println(numList.groupBy {it % 2})

    //println(numList.indexBy {it % 2})

    //val dupList = listOf(0, 1, 2, 1, 3, 6, 3)
    //println(dupList.uniq())


    val list10 = (1..10).toList()

    myEachSlice(list10, 3) {
        println(it)
    }

    list10.eachSlice(3) {
        println(it)
    }

}

fun <T> Iterable<T>.eachSlice(countInSlice: Int, cb: (List<T>) -> Unit) {
    var slice = mutableListOf<T>()
    for (s in this) {
        slice.add(s)

        if (slice.size == countInSlice) {
            cb(slice)
            slice = mutableListOf<T>()
        }
    }

    if (slice.size > 0) {
        cb(slice)
    }
}

fun <T> myEachSlice(src: List<T>, countInSlice: Int, cb: (List<T>) -> Unit) {
    var slice = mutableListOf<T>()
    for (s in src) {
        slice.add(s)

        if (slice.size == countInSlice) {
            cb(slice)
            slice = mutableListOf<T>()
        }
    }

    if (slice.size > 0) {
        cb(slice)
    }
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

fun myFilter1(src: List<String>, cb: (String) -> Boolean): List<String> {
    val result = mutableListOf<String>()
    for (s in src) {
        if (cb(s)) {
            result.add(s)
        }
    }
    return result
}

fun myMap1(src: List<String>, cb: (String) -> String): List<String> {
    val result = mutableListOf<String>()
    for (s in src) {
        result.add(cb(s))
    }
    return result
}

fun <T, R> myMap2(src: List<T>, cb: (T) -> R): List<R> {
    val result = mutableListOf<R>()
    for (s in src) {
        result.add(cb(s))
    }
    return result
}

fun <T, R> List<T>.myMap3(cb: (T) -> R): List<R> {
    val result = mutableListOf<R>()
    for (s in this) {
        result.add(cb(s))
    }
    return result
}

fun <T, R> Iterable<T>.myMap4(cb: (T) -> R): List<R> {
    val result = mutableListOf<R>()
    for (s in this) {
        result.add(cb(s))
    }
    return result
}

fun <T> Iterable<T>.reject(cb: (T) -> Boolean): List<T> {
    return filter {
        !cb(it)
    }
}

fun <T, R> Iterable<T>.indexBy(cb: (T) -> R): Map<R, T> {
    return this.map { cb(it) to it }.toMap()
}

fun <T> Collection<T>.uniq(): Iterable<T> {
    return this.toSet()
}


