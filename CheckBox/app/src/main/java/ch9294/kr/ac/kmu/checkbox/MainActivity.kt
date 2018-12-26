package ch9294.kr.ac.kmu.checkbox

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { v ->
            textView.text = ""

            if (checkBox.isChecked) {
                textView.append("체크박스1이 체크되었습니다.\n")
            }
            if (checkBox2.isChecked) {
                textView.append("체크박스2이 체크되었습니다.\n")
            }
            if (checkBox3.isChecked) {
                textView.append("체크박스3이 체크되었습니다.\n")
            }
        }

        button2.setOnClickListener { v ->
            checkBox.isChecked = true
            checkBox2.isChecked = true
            checkBox3.isChecked = true
        }

        button3.setOnClickListener { v ->
            checkBox.isChecked = false
            checkBox2.isChecked = false
            checkBox3.isChecked = false
        }

        button4.setOnClickListener { v ->
            checkBox.toggle()
            checkBox2.toggle()
            checkBox3.toggle()
        }

        checkBox.setOnCheckedChangeListener(CheckBoxListener())
        checkBox2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                textView.text = "이벤트 : 체크박스2이 체크되었습니다."
            } else {
                textView.text = "이벤트 : 체크박스2이 체크 해제 되었습니다."
            }
        }
        checkBox3.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                textView.text = "이벤트 : 체크박스3이 체크되었습니다."
            } else {
                textView.text = "이벤트 : 체크박스3이 체크 해제 되었습니다."
            }
        }
    }

    inner class CheckBoxListener : CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            if (isChecked) {
                textView.text = "이벤트 : 체크박스1이 체크되었습니다."
            } else {
                textView.text = "이벤트 : 체크박스1이 체크 해제 되었습니다."
            }
        }
    }
}
