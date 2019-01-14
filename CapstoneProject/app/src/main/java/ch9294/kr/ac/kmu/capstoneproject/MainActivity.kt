package ch9294.kr.ac.kmu.capstoneproject

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var myIntent: Intent? = null
    val SIGN_UP_ACTIVITY = 0
    val USER_INFO_ACTIVITY = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signUpBtn.setOnClickListener { v ->
            myIntent = Intent(this, SignUpActivity::class.java)
            startActivityForResult(myIntent, SIGN_UP_ACTIVITY)
        }

        loginBtn.setOnClickListener { v ->
            myIntent = Intent(this, UserInfoActivity::class.java)
            startActivityForResult(myIntent, USER_INFO_ACTIVITY)
        }
    }
    
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            SIGN_UP_ACTIVITY -> {
                // 회원가입 페이지에서 돌아왔을때
                when (requestCode) {
                    Activity.RESULT_OK -> {
                        Toast.makeText(this, "정상적으로 가입되었습니다", Toast.LENGTH_SHORT).show()
                    }
                    Activity.RESULT_CANCELED -> {
                        Toast.makeText(this, "가입 진행이 되지 않았습니다", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            USER_INFO_ACTIVITY -> {

            }
        }
    }
}
