import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main(argv: Array<String>) {
    println(LocalDate.parse("2017-01-10"))
    println(LocalDate.parse("2017/02/10", DateTimeFormatter.ofPattern("yyyy/MM/dd")))
}