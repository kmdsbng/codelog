fun main(argv: Array<String>) {
    val mutableItems = mutableListOf("Bob", "John", "Alice")
    val items = mutableItems.toList()

    println(items.first())
    println(items.last())
    println(items.joinToString(","))

    println(items.filter {it.length <= 4})

    val first = items[0]
    println(first)
    val firstOrNull = items.firstOrNull()
    println(firstOrNull)

    val noItems = listOf<String>()
    //val firstButNothing = noItems[0]
    //println(firstButNothing)
    ////Exception in thread "main" java.lang.IndexOutOfBoundsException: Empty list doesn't contain element at index 0.
    ////at kotlin.collections.EmptyList.get(Collections.kt:45)
    ////at kotlin.collections.EmptyList.get(Collections.kt:33)
    ////at AppKt.main(App.kt:16)

    val firstOrNullOfNoItems = noItems.getOrNull(0)
    println(firstOrNullOfNoItems)

    val ary = arrayOf("Bob", "John", "Alice")
    println(ary[2])
    //println(ary[3])
    ////Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
    ////at AppKt.main(App.kt:28)

    println(ary.getOrNull(2))
    println(ary.getOrNull(3))
    println(ary.getOrElse(3, { "hoge" }))
}