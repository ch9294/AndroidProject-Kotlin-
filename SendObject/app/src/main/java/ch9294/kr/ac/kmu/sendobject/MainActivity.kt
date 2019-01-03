package ch9294.kr.ac.kmu.sendobject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { v ->
            var t1 = TestClass()
            t1.data10 = 100
            t1.data20 ="string1"

            var intent = Intent(this,Main2Activity::class.java)
            intent.putExtra("test1",t1)

            startActivityForResult(intent,100)
        }
    }
}
