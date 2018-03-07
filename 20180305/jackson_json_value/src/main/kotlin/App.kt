import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.ObjectMapper
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class SampleDate(
        val date: LocalDate
) {
    @JsonValue
    override fun toString(): String {
        return date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
    }

}

fun main(argv: Array<String>) {
    val mapper = ObjectMapper()

    val sampleDates = listOf(
            SampleDate(LocalDate.of(2018, 1, 1)),
            SampleDate(LocalDate.of(2018, 1, 2))
    )
    val json = mapper.writeValueAsString(sampleDates)

    println(json)
}