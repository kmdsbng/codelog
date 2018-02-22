import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun canPushOperand() {
        calculator.pushOperand(3)
        Assertions.assertEquals(3, calculator.getResult())
        calculator.pushOperand(5)
        Assertions.assertEquals(5, calculator.getResult())
    }

    @Test
    fun canAdd() {
        calculator.pushOperand(3)
        calculator.pushOperand(5)
        calculator.pushOperator("+")
        Assertions.assertEquals(8, calculator.getResult())
    }
}