package ch9294.kr.ac.kmu.sendobject

import android.os.Parcel
import android.os.Parcelable
/*
Parcelable 인터페이스를 구현한 객체만 인텐트로 전달이 가능하다.
실제로 객체가 전달되는 것은 아니고, 목적지에서 전달하는 객체를 똑같이 새로 생성하는 것이다.
즉, Parcelable 인터페이스에서 제공하는 메소드를 통해서 전달하고자 하는 객체의 내용을 저장하고
객체를 수신받는 곳에서 다시 객체를 복원시키는 것이다.
 */
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
                /*
                객체를 복원시키는 곳
                 */
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