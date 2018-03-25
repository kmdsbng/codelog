
https://qiita.com/opengl-8080/items/36351dca891b6d9c9687

拡張関数で書いてみた。

fun <T, R> List<T>.myMap2(cb: (T) -> R): List<R>


fun <T, R> Iterable<T>.myMap3(cb: (T) -> R): List<R>

interface ListはCollectionを継承していて、CollectionはさらにIterableを継承している。
Iterableはiterator() のみを提供しているinterface。
Kotlin組み込みのmapメソッドも、Iterableへの拡張関数として定義されている。

https://github.com/JetBrains/kotlin/blob/1.2.40_182/libraries/stdlib/src/generated/_Collections.kt#L1245


rubyのeach_sliceを移植してみた。

partitionはkotlinの組み込み関数として定義されてる。

rejectを移植してみた。

sum() もKotlinですでに定義されてる。

take() もKotlinですでに定義されてる。

uniq() の代わりに toSet() で要望は満たせそう。

groupBy() もKotlinですでに定義されてる。

indexBy() を定義してみた。



