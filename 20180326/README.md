

tailrec付けても、以下のメソッドを末尾再帰と見なしてくれない。たぶん末尾再帰最適化できると思うんだけど...

```
class Cons<E>(override val size: Int, val e: E?, val next: Cons<E>?) : List<E> {

    tailrec fun toStringIter(prevStr: String): String {
        if (next == null) {
            return prevStr
        }
        val str = "${prevStr}, ${e.toString()}"
        return next.toStringIter(str)
    }
```
