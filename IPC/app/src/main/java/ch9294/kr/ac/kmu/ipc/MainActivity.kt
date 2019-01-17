package ch9294.kr.ac.kmu.ipc

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent = Intent(this, IPCService::class.java)
        if (isServiceRunning("ch9294.kr.ac.kmu.ipc.IPCService") == false) {
            Toast.makeText(this,"서비스 가동",Toast.LENGTH_SHORT
            ).show()
            startService(intent)
        }
    }

    private fun isServiceRunning(name: String): Boolean {
        val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        for (service in manager.getRunningServices(Int.MAX_VALUE)) {
            if (service.service.className.equals(name)) {
                return true
            }
        }
        return false
    }
}
