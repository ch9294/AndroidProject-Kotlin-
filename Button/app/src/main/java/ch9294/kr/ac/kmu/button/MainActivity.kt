package ch9294.kr.ac.kmu.button

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var listener1 = BtnListener()
//        button.setOnClickListener(listener1)
//        button2.setOnClickListener(listener1)
//        button3.setOnClickListener(listener1)
//        button4.setOnClickListener(listener1)
//
//        button5.setOnClickListener { v: View? -> textView.text = "다섯번째 버튼" }
//
//        button6.setOnClickListener { v: View? -> textView.text = "여섯번째 버튼" }
//
//        var listener2 = View.OnClickListener { view ->
//            when (view) {
//                button7 -> textView.text = "일곱번째 버튼"
//                button8 -> textView.text = "여덟번째 버튼"
//            }
//        }
//
//        button7.setOnClickListener(listener2)
//        button8.setOnClickListener(listener2)

        val listenerLast = View.OnClickListener { v: View? ->
            when (v) {
                button -> textView.text = "첫 번째 버튼을 눌렀습니다."
                button2 -> textView.text = "두 번째 버튼을 눌렀습니다."
                button3 -> textView.text = "세 번째 버튼을 눌렀습니다."
                button4 -> textView.text = "네 번째 버튼을 눌렀습니다."
                button5 -> textView.text = "다섯 번째 버튼을 눌렀습니다."
                button6 -> textView.text = "여섯 번째 버튼을 눌렀습니다."
                button7 -> textView.text = "일곱 번째 버튼을 눌렀습니다."
                button8 -> textView.text = "여덟 번째 버튼을 눌렀습니다."
                exitBtn -> finish()
            }
        }

        button.setOnClickListener(listenerLast)
        button2.setOnClickListener(listenerLast)
        button3.setOnClickListener(listenerLast)
        button4.setOnClickListener(listenerLast)
        button5.setOnClickListener(listenerLast)
        button6.setOnClickListener(listenerLast)
        button7.setOnClickListener(listenerLast)
        button8.setOnClickListener(listenerLast)
        exitBtn.setOnClickListener(listenerLast)
    }

    inner class BtnListener : View.OnClickListener {
        override fun onClick(v: View?) {
            when (v) {
                button -> textView.text = "첫 번째 버튼을 눌렀습니다."
                button2 -> textView.text = "두 번째 버튼을 눌렀습니다."
                button3 -> textView.text = "세 번째 버튼을 눌렀습니다."
                button4 -> textView.text = "네 번째 버튼을 눌렀습니다."
            }
        }
    }
}
