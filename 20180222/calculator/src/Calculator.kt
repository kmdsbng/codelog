class Calculator {
    val stack = mutableListOf<Int>()
    fun pushOperand(operand: Int) {
        stack.add(operand)
    }

    fun pushOperator(operand: String) {
        when(operand) {

            "+" -> {
                val right = stack.removeAt(stack.count() - 1)
                val left = stack.removeAt(stack.count() - 1)
                stack.add(right + left)
            }
        }

    }

    fun getResult(): Int {
        return stack.last()
    }

}