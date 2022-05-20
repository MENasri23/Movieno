package ir.jatlin.domain.movie.filter

interface ParameterMaker<K, V> {

    fun put(key: K, value: V)

    fun remove(key: K): V?

}

class DefaultParameterMaker<K, V>(
    defaults: Map<K, V>? = null
) : ParameterMaker<K, V> {

    private val _params = defaults?.toMutableMap() ?: HashMap()
    val params: Map<K, V> get() = _params

    override fun put(key: K, value: V) {
        _params[key] = value

    }

    override fun remove(key: K): V? {
        return _params.remove(key)
    }
}