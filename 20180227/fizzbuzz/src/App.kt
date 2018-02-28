
// 基本問題
fun main(args: Array<String>) {
    val values = generateFizzBuzz()
    values.forEach {
        println(it)
    }
}

private fun generateFizzBuzz(): List<Any> {
    val values = (1..100).map {
        when {
            (it % 15 == 0) -> {
                "FizzBuzz"
            }
            (it % 5 == 0) -> {
                "Buzz"
            }
            (it % 3 == 0) -> {
                "Fizz"
            }
            else -> {
                it
            }
        }
    }
    return values
}


