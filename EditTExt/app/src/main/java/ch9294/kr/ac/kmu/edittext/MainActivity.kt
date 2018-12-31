package ch9294.kr.ac.kmu.edittext

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { v ->
            textView.text = editText2.text
        }

        /*
        EditText 에 문자열을 설정할때는 setText 메소드를 사용한다.
        EditText에 저장되는 문자열은 String이 아니라 Editable이기 때문이다.
         */
        button2.setOnClickListener { v ->
            editText2.setText("문자열")
        }

        val listener1 = EnterListener()
        editText2.setOnEditorActionListener(listener1)

        val watcher = EditWatcher()
        editText2.addTextChangedListener(watcher)
    }

    inner class EnterListener : TextView.OnEditorActionListener {
        // 엔터키를 누를때 이벤트가 발생한다.
        override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
            textView.text = editText2.text

            // true를 반환할 경우 엔터키를 누르고 나서도 키보드가 계속 유지됨
            // false를 반환할 경우 엔터키를 누르고 나면 키보드가 내려감
            return true
        }
    }

    inner class EditWatcher : TextWatcher {
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // 입력 할 때마다
            textView.text = s
        }
    }
}
