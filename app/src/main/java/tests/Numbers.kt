package tests

interface Numbers {

    fun sum(): Int
    fun dif(): Int
    fun div(): Int

    class Base(
       private val i: Int,
       private val i1: Int
    ) : Numbers {
        override fun sum(): Int {
           return i1 + i
        }

        override fun dif(): Int {
            return i - i1
        }

        override fun div(): Int {
            return i / i1
        }
    }


}