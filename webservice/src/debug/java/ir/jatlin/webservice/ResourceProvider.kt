package ir.jatlin.webservice

object ResourceProvider {
    private val resourceLoader = javaClass.classLoader

    fun readFrom(fileName: String) =
        resourceLoader?.getResource(fileName)?.readText()
}