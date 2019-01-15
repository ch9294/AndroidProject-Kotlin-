package ch9294.kr.ac.kmu.contentprovider

import android.content.ContentValues
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 작업 요청의 대상이 되는 어플리케이션 내의 컨텐트 프로바이더의 주소
        val uri = Uri.parse("content://kr.co.kmu.dbprovider")

        button.setOnClickListener { v ->

            val c = contentResolver.query(uri, null, null, null, null)
            textView.text = ""

            while (c.moveToNext()) {
                val idxPos = c.getColumnIndex("idx")
                val textdataPos = c.getColumnIndex("textData")
                val intDataPos = c.getColumnIndex("intData")
                val floatDataPos = c.getColumnIndex("floatData")
                val dateDataPos = c.getColumnIndex("dateData")

                val idx = c.getInt(idxPos)
                val textData = c.getString(textdataPos)
                val intData = c.getInt(intDataPos)
                val floatData = c.getDouble(floatDataPos)
                val dateData = c.getString(dateDataPos)

                textView.append("idx : ${idx}\n")
                textView.append("textData : ${textData}\n")
                textView.append("intData : ${intData}\n")
                textView.append("floatDate : ${floatData}\n")
                textView.append("dateData : ${dateData}\n\n")
            }
        }

        button2.setOnClickListener { v ->
            val sdf = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault())
            var date = sdf.format(Date())

            val cv1 = ContentValues()
            val cv2 = ContentValues()

            cv1.put("textData", "문자열3")
            cv1.put("intData", 300)
            cv1.put("floatData", 33.44)
            cv1.put("dateData", date)

            cv2.put("textData", "문자열4")
            cv2.put("intData", 400)
            cv2.put("floatData", 44.44)
            cv2.put("dateData", date)

            contentResolver.insert(uri, cv1)
            contentResolver.insert(uri, cv2)

            textView.text = "저장완료"

        }

        button3.setOnClickListener { v ->
            val cv = ContentValues()
            cv.put("textData", "문자열100")
            val where = "idx = ?"
            val args = arrayOf("3")

            contentResolver.update(uri, cv, where, args)
            textView.text = "수정 완료"
        }

        button4.setOnClickListener { v ->
            val cv = ContentValues()
            val where = "idx = ?"
            val args = arrayOf("2")
            contentResolver.delete(uri, where, args)
            textView.text = "삭제 완료"
        }
    }
}
