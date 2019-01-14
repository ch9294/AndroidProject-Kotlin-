package ch9294.kr.ac.kmu.capstoneproject

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    val toast = Toast(this)
    val view_list = listOf<EditText>(
        editName, editId, editPassword, editConfirm, editAge
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        // 입력한 모든 내용을 초기화한다.
        fun editClear() {
            editName.clearComposingText()
            editId.clearComposingText()
            editPassword.clearComposingText()
            editConfirm.clearComposingText()
            editAge.clearComposingText()
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        editConfirm.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (editPassword.toString() === s?.toString()) {
                    return;
                } else {
                    toast.setText("비밀번호가 맞지 않습니다.")
                    toast.duration = Toast.LENGTH_LONG
                    toast.show()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        submitBtn.setOnClickListener { v ->
            setResult(Activity.RESULT_OK)
        }

        resetBtn.setOnClickListener { v ->
            editClear()
            Toast.makeText(this, "초기화 되었습니다.", Toast.LENGTH_SHORT).show()
        }

        returnBtn.setOnClickListener { v ->
            editClear()
            setResult(Activity.RESULT_CANCELED)
        }
    }

}
