import java.time.LocalDate

data class SampleDate(
        val date: LocalDate
)

fun main(argv: Array<String>) {
    val sampleDate = SampleDate(LocalDate.of(2018, 3, 5))


    val mapper = ObjectMapper()
    val json = mapper.writeValueAsString(hoge)
}

