package ch9294.kr.ac.kmu.progressbar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
/*
 프로그레스 바의 경우 별도의 리스너가 존재 하지 않음
 incrementProgressBy() 메소드를 이용해서 진행 상태를 조정 할 수 있음
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnListener = BtnListener()
        button.setOnClickListener(btnListener)
        button2.setOnClickListener(btnListener)
        button3.setOnClickListener(btnListener)
        button4.setOnClickListener(btnListener)

    }

    inner class BtnListener : View.OnClickListener {
        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.button -> progressBar2.incrementProgressBy(5)
                R.id.button2 -> progressBar2.incrementProgressBy(-5)
                R.id.button3 -> progressBar2.incrementProgressBy(50)
                R.id.button4 -> progressBar2.progress = 0
            }
        }
    }
}
