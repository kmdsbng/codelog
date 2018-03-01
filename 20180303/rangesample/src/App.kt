fun main(argv: Array<String>) {
    if (2 in 1..10) {
        println(2)
    }

    if (10 in 1..10) {
        println(10)
    }

    if (11 in 1..10) {
        println(11)
    }

    (1..10).step(2).forEach {
        println(it)
    }

    (10..1).step(2).forEach {
        println(it)
    }

    (10 downTo 1).step(2).forEach {println(it)}

    (10..20).reversed().step(2).forEach {println(it)}
}