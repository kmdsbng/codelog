fun main(argv: Array<String>) {

    var a: String = "abc"
    //a = null // compilation error

    var b: String? = "abc"
    b = null // ok

    val l = a.length

    //val lb = b.length // error: variable 'b' can be null


    if (b != null && b.length > 0) {
        println("String of length ${b.length}")
    } else {
        println("Empty string")
    }
    val lb2 = b?.length // error: variable 'b' can be null
    println(lb2)

    // Elvis operator
    val lb3 = b?.length ?: -1

    println(lb3)

    val nullableList: List<Int?> = listOf(1, 2, null, 4)
    val nonnullList = nullableList.filterNotNull()
}

