package tests

interface Count {
    fun click()

    interface Callback{
        fun provide(value: String)
    }

    class Base(
        private val callback: Callback
    ) : Count{
        private  var value = 0

        override fun click() {
            callback.provide((++value).toString())
        }
    }
}