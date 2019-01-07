package ch9294.kr.ac.kmu.service

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.os.SystemClock
import android.util.Log

// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "ch9294.kr.ac.kmu.service.action.FOO"
private const val ACTION_BAZ = "ch9294.kr.ac.kmu.service.action.BAZ"

// TODO: Rename parameters
private const val EXTRA_PARAM1 = "ch9294.kr.ac.kmu.service.extra.PARAM1"
private const val EXTRA_PARAM2 = "ch9294.kr.ac.kmu.service.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class ServiceClass2 : IntentService("ServiceClass2") {

    // onStartCommand가 끝나게 되면 호출되면 자동적으로 호출된다.
    // 이 메소드는 자동적으로 쓰레드로 처리된다.
    override fun onHandleIntent(intent: Intent?) {
        var idx = 0
        while (idx < 20) {
            SystemClock.sleep(1000)
            var times = System.currentTimeMillis()
            Log.d("test2", "Intent Service Running : ${times}")
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        return super.onStartCommand(intent, flags, startId)
    }
}
