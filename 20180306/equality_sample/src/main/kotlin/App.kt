
data class A(
        val a: String,
        val b: Long
)

class B(
        val a: String,
        val b: Long
)


fun main(argv: Array<String>) {

    println(A("a", 1L) == A("a", 1L))
    println(A("a", 1L) == A("a", 2L))
    println(arrayOf(1, 2, 3) == arrayOf(1, 2, 3))
    println(B("a", 1L) == B("a", 1L))
    println(1 == 1)
    println(0.1 == 0.1)
}