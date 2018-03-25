
class Cons<E>(override val size: Int, val e: E?, val next: Cons<E>?) : List<E> {

    override fun toString(): String {
        //return toStringIter("")
        return toStringLoop(this)
    }

    tailrec fun toStringIter(prevStr: String): String {
        if (next == null) {
            return prevStr
        }
        val str = "${prevStr}, ${e.toString()}"
        return next.toStringIter(str)
    }

    fun toStringLoop(first: Cons<E>): String {
        var result: String = ""
        var car: Cons<E>? = first
        while(car != null && car.next != null) {
            result = "${result}, ${car.e}"
            car = car.next
        }
        return result
    }

    constructor(e: E, next: Cons<E>): this(next.size + 1, e, next) {
    }

    constructor(): this(0, null, null) {
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<E> {
        throw IndexOutOfBoundsException()
    }

    override fun listIterator(index: Int): ListIterator<E> {
        throw IndexOutOfBoundsException()
    }

    override fun listIterator(): ListIterator<E> {
        throw IndexOutOfBoundsException()
    }

    override fun lastIndexOf(element: E): Int {
        return 0
    }

    override fun iterator(): Iterator<E> {
        throw IndexOutOfBoundsException()
    }

    override fun isEmpty(): Boolean {
        return true
    }

    override fun indexOf(element: E): Int {
        throw IndexOutOfBoundsException()
    }

    override fun get(index: Int): E {
        throw IndexOutOfBoundsException()
    }

    override fun containsAll(elements: Collection<E>): Boolean {
        return false
    }

    override fun contains(element: E): Boolean {
        return false
    }

    //override val size: Int = 0

    //constructor(): super(0) {

    //}

    //constcuctor() {
    //    this.size = 0
    //}

}


fun main(argv: Array<String>) {
    var car: Cons<String> = Cons<String>()
    car = Cons<String>("2", car)
    car = Cons<String>("1", car)
    car = Cons<String>("0", car)

    val list: List<String> = car
    println(list)

    println(
        (1..10000).mapWithCons { it * 2 }
    )

}

fun <T, R> Iterable<T>.mapWithCons(cb: (T) -> R): List<R> {
    return mapWithConsIter(Cons<R>(), this.iterator(), cb)
}

tailrec fun <T, R> Iterable<T>.mapWithConsIter(result: Cons<R>, src: Iterator<T>, cb: (T) -> R): List<R> {
    if (!src.hasNext()) {
        return result
    }
    val e = src.next()
    return mapWithConsIter(Cons<R>(cb(e), result), src, cb)
}
