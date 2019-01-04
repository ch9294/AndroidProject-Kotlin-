package ch9294.kr.ac.kmu.activityaction

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    var permission_list = arrayOf(
        android.Manifest.permission.CALL_PHONE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission()

        button.setOnClickListener { v ->
            var uri = Uri.parse("geo:37.243243.131.8610601")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        button2.setOnClickListener { v ->
            var uri = Uri.parse("http://developer.android.com")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        button3.setOnClickListener { v ->
            var uri = Uri.parse("tel:00000000")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

        button4.setOnClickListener { v ->
            var uri = Uri.parse("tel:11112222")
            var intent = Intent(Intent.ACTION_CALL, uri)
            startActivity(intent)
        }
    }

    fun checkPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
//            Toast.makeText(this,"버전이 맞지않습니다.",Toast.LENGTH_SHORT).show()
            return
        }

        for (permission in permission_list) {
            var chk = checkCallingOrSelfPermission(permission)

            if (chk == PackageManager.PERMISSION_DENIED) {
                requestPermissions(permission_list, 0)
                break
            }
        }
    }
}
