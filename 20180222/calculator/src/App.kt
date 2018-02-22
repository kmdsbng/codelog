
fun main(argv: Array<String>) {
    val calculator = Calculator()

    calculator.pushOperand(3)
    calculator.pushOperand(5)
    calculator.pushOperator("+")
    println(calculator.getResult())
}

