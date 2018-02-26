import java.time.LocalDate
import java.util.Arrays
import java.text.SimpleDateFormat
import com.google.gson.Gson
import sun.plugin2.util.PojoUtil.toJson







class ActorGson(
    val imdbId: String?,
    val dateOfBirth: LocalDate?,
    val filmography: List<String>?

) {
    override fun toString(): String {
        return "ActorGson [imdbId=" + imdbId + ", dateOfBirth=" + dateOfBirth + ", filmography=" + filmography + "]"
    }
}

class Movie(
    val imdbId: String?,
    val director: String?,
    val actors: List<ActorGson>?
) {
    override fun toString(): String {
        return "Movie [imdbId=" + imdbId + ", director=" + director + ", actors=" + actors + "]"
    }
}

fun main(argv: Array<String>) {

    gsonSample()
}

private fun gsonSample() {
    val rudyYoungblood = ActorGson(
            "nm2199632",
            LocalDate.of(1982, 9, 21),
            Arrays.asList("Apocalypto",
                    "Beatdown", "Wind Walkers")
    )
    val movie = Movie(
            "tt0472043",
            "Mel Gibson",
            Arrays.asList(rudyYoungblood))

    val serializedMovie = Gson().toJson(movie)

    println(serializedMovie)


    val outputMovie = Gson().fromJson(serializedMovie, Movie::class.java)
    println(outputMovie)
}