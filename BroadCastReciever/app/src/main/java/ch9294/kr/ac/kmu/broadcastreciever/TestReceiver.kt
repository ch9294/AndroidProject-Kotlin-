package ch9294.kr.ac.kmu.broadcastreciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class TestReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        var t1 = Toast.makeText(context, "리시버 동작", Toast.LENGTH_SHORT)
        t1.show()
    }
}
