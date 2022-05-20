package ir.jatlin.domain.movie.filter

fun <K, V> DefaultParameterMaker<in K, in V>.putAll(vararg pairs: Pair<K, V>) {
    for ((key, value) in pairs) {
        put(key, value)
    }
}