

fun main(argv: Array<String>) {
    println(fib(1))
    println(fib(2))
    println(fib(10))
    println(fib(100))
}


fun fib(end: Int): Long {
    if (end == 0) {
        return 0L
    }

    if (end == 1) {
        return 1L
    }

    return fibIter(2, end, 1L, 0L)
}

tailrec fun fibIter(cur: Int, end: Int, last: Long, last2: Long): Long {
    if (end <= cur) {
        return last + last2
    }
    return fibIter(cur + 1, end, last + last2, last)
}

// Warning: A function is marked as tail-recursive but no tail calls are found.
tailrec fun fibIterFailed(cur: Int, end: Int, last: Long, last2: Long): Long {
    if (end <= cur) {
        return last + last2
    }
    return fibIter(cur + 1, end, last + last2, last) + 1
}


