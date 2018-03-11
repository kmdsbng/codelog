fun main(argv: Array<String>) {
    println("Hello, World!2")

    val point1 = Point(10, 20)
    println(-point1)

    val point2 = Point(20, 40)
    println(point1 + point2)

    println(point2 - point1)
}


data class Point(val x: Int, val y: Int) {
    operator fun plus(right: Point): Point = Point(x + right.x, y + right.y)

    operator fun unaryMinus() = Point(-x, -y)
    operator fun minus(right: Point): Point {
        return Point(x - right.x, y - right.y)
    }
}


