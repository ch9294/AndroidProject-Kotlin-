package ch9294.kr.ac.kmu.capstoneproject

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_sign_up.*

class LogingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loging)
    }

    fun insert(view: View) {
        val id = editId.toString()
        val pw = editPassword.toString()

        insertToDatabase(id, pw)
    }

    fun insertToDatabase(id: String, pw: String) {

    }

    inner class InsertData : AsyncTask<String, Unit, String>() {
        override fun onPreExecute() {

        }

        override fun doInBackground(vararg params: String?): String {
            try {
                val id = params[0]
                val pw = params[1]
            }
        }

        override fun onPostExecute(result: String?) {

        }
    }
}
