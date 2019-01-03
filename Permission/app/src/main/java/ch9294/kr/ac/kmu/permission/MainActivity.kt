package ch9294.kr.ac.kmu.permission

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val permission_list = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.READ_SMS,
        Manifest.permission.RECEIVE_SMS,
        Manifest.permission.READ_CONTACTS,
        Manifest.permission.WRITE_CONTACTS,
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkPermission()
    }

    fun checkPermission() {
        // 마시멜로 버전 밑으로는 사용하지 않음
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }

        for(permission : String in permission_list ){
            val chk = checkCallingOrSelfPermission(permission)
            when(chk){
                PackageManager.PERMISSION_DENIED -> requestPermissions(permission_list,0)
            }
        }
    }
}
