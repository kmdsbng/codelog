import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CalculatorTest {
    @Test
    fun testSum() {
        val calculator = Calculator()
        assertEquals(7, calculator.sum(1, 6))
    }
}