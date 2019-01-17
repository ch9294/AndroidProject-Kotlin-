package ch9294.kr.ac.kmu.ipc

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock
import android.util.Log

class IPCService : Service() {

    var value = 0
    var thread :ThreadClass? = null

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        thread?.start()
        return super.onStartCommand(intent, flags, startId)
    }

    inner class ThreadClass : Thread() {
        override fun run() {
            while (true) {
                SystemClock.sleep(1000)
                Log.d("test1", "value : ${value}")
                value++
            }
        }
    }
}
