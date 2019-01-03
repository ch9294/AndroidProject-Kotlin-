package ch9294.kr.ac.kmu.sendobject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var t1 = intent.getParcelableExtra<TestClass>("test1")

        textView2.text = "t1.data10 = ${t1.data10}\n"
        textView2.append("t1.data20 = ${t1.data20}\n")
    }
}
