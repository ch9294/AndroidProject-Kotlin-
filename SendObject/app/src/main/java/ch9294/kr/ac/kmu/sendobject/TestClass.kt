package ch9294.kr.ac.kmu.sendobject

import android.os.Parcel
import android.os.Parcelable

class TestClass : Parcelable {
    var data10: Int = 0
    var data20: String? = null

    companion object {
        /*
        이름은 반드시 CREATOR 로 해야한다!!!
         */
        @JvmField
        val CREATOR: Parcelable.Creator<TestClass> = object : Parcelable.Creator<TestClass> {
            override fun createFromParcel(source: Parcel?): TestClass {
                val test = TestClass()
                test.data10 = source?.readInt()!!
                test.data20 = source?.readString()

                return test
            }

            override fun newArray(size: Int): Array<TestClass?> {
                return arrayOfNulls<TestClass>(size)
            }
        }
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        /*
        차례대로 데이터를 설정해야함!!!
         */
        dest?.writeInt(data10)
        dest?.writeString(data20)
    }

    override fun describeContents(): Int {
        return 0
    }

}