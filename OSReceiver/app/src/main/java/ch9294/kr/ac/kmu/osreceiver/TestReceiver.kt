package ch9294.kr.ac.kmu.osreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsManager
import android.telephony.SmsMessage
import android.widget.Toast

class TestReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
//        TODO("TestReceiver.onReceive() is not implemented")

        when (intent.action) {
            "android.intent.action.BOOT_COMPLETED" -> {
                Toast.makeText(context, "부팅완료", Toast.LENGTH_SHORT).show()
            }
            "android.provider.Telephoney.SMS_RECEIVED" -> {
                var str = ""
                var bundle = intent.extras
                if (bundle != null) {
                    var obj = bundle.get("pdus") as Array<Any>
                    var msg = arrayOfNulls<SmsMessage>(obj.size)

                    for (i in obj.indices) {
                        msg[i] = SmsMessage.createFromPdu(obj[i] as ByteArray)
                    }

                    for (i in msg.indices) {
                        str = msg[i]?.originatingAddress + " : " + msg[i]?.messageBody
                        Toast.makeText(context, str, Toast.LENGTH_SHORT)
                    }
                }
            }
        }
    }
}
