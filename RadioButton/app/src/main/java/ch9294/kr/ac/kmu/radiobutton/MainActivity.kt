package ch9294.kr.ac.kmu.radiobutton

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { v ->
            when (radioG1.checkedRadioButtonId) {
                R.id.radioButton -> textView.text = "라디오1-1 선택되었습니다."
                R.id.radioButton2 -> textView.text = "라디오1-2 선택되었습니다."
                R.id.radioButton2 -> textView.text = "라디오1-3 선택되었습니다."
            }

            when (radioG2.checkedRadioButtonId) {
                R.id.radioButton4 -> textView2.text = "라디오2-1 선택되었습니다."
                R.id.radioButton5 -> textView2.text = "라디오2-2 선택되었습니다."
                R.id.radioButton6 -> textView2.text = "라디오2-3 선택되었습니다."
            }
        }

//        val radioListener = RadioListener()
//        radioG1.setOnCheckedChangeListener(radioListener)
//        radioG2.setOnCheckedChangeListener(radioListener)
        radioG1.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioButton -> textView.text = "Check Event : Radio 1-1 checked"
                R.id.radioButton2 -> textView.text = "Check Event : Radio 1-2 checked"
                R.id.radioButton3 -> textView.text = "Check Event : Radio 1-3 checked"
            }
        }

        radioG2.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioButton4 -> textView2.text = "Check Event : Radio 2-1 Checked"
                R.id.radioButton5 -> textView2.text = "Check Event : Radio 2-2 Checked"
                R.id.radioButton6 -> textView2.text = "Check Event : Radio 2-3 Checked"
            }
        }
        
        button2.setOnClickListener { v ->
            radioButton2.isChecked = true
            radioButton6.isChecked = true
        }
    }

    inner class RadioListener : RadioGroup.OnCheckedChangeListener {
        override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
            when (group?.id) {
                R.id.radioG1 -> when (checkedId) {
                    R.id.radioButton -> textView.text = "Check Event : Radio 1-1 checked"
                    R.id.radioButton2 -> textView.text = "Check Event : Radio 1-2 checked"
                    R.id.radioButton3 -> textView.text = "Check Event : Radio 1-3 checked"
                }
                R.id.radioG2 -> when (checkedId) {
                    R.id.radioButton4 -> textView2.text = "Check Event : Radio 2-1 Checked"
                    R.id.radioButton5 -> textView2.text = "Check Event : Radio 2-2 Checked"
                    R.id.radioButton6 -> textView2.text = "Check Event : Radio 2-3 Checked"
                }
            }
        }
    }
}
