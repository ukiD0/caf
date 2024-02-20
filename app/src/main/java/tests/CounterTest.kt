package tests

import org.junit.Assert.assertEquals
import org.junit.Test

class CountTest {
    @Test
    fun test() {
        val callback: FakeCallBack = FakeCallBack.Base()
        var count: Count = Count.Base(callback)
        count.click()
        assertEquals("1",callback.count())
    }

    private interface FakeCallBack : Count.Callback{

        fun count(): String

        class Base: FakeCallBack {
            private var value = " "

            override fun provide(value: String) {
                this.value = value
            }

            override fun count(): String {
                return value
            }
        }
    }
}
