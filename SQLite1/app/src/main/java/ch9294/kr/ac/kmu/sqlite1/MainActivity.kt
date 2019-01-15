package ch9294.kr.ac.kmu.sqlite1

import android.content.ContentValues
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { v ->
            val helper = DBHelper(this)
            val db = helper.writableDatabase

//            val sql = """
//                insert into TestTable (textData, intData, floatData, dateData) values (?,?,?,?)
//            """.trimIndent()
//
//            val sdf = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault())
//            var date = sdf.format(Date())
//
//            val arg1 = arrayOf("문자열1,", "100", "11.11", date)
//            val arg2 = arrayOf("문자열2,", "200", "22.22", date)
//
//            db.execSQL(sql, arg1)
//            db.execSQL(sql, arg2)

            val sdf = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault())
            var date = sdf.format(Date())

            val cv1 = ContentValues()
            val cv2 = ContentValues()

            cv1.put("textData", "문자열1")
            cv1.put("intData", 100)
            cv1.put("floatData", 11.11)
            cv1.put("dateData", date)

            cv2.put("textData", "문자열2")
            cv2.put("intData", 200)
            cv2.put("floatData", 22.22)
            cv2.put("dateData", date)

            db.insert("TestTable", null, cv1)
            db.insert("TestTable", null, cv2)

            db.close()

            textView.text = "저장 완료"
        }

        button2.setOnClickListener { v ->
            val helper = DBHelper(this)
            val db = helper.writableDatabase
//            val sql = """
//                select * from TestTable
//            """.trimIndent()
//
//            var c: Cursor = db.rawQuery(sql, null)

            /*
            첫번째는 테이블의 이름
            두번째는 가져올 컬럼 이름의 문자열 배열(null을 넣을 경우 전부 불러옴)
            세번째는 where 조건절이다. 값이 들어가는 부분은 ?로 입력하면 된다.
            네번째는 조건절의 ?에 셋팅될 값의 문자열 배열
            다섯번째 정렬 기준
            여섯번째는 GroupBy
            일곱번쨰 Having
             */
            var c = db.query("TestTable",null,null,null,null,null,null)
            textView.text = ""

            while (c.moveToNext()) {
                var idx_pos = c.getColumnIndex("idx")
                var textdata_pos = c.getColumnIndex("textData")
                var intData_pos = c.getColumnIndex("intData")
                var floatData_pos = c.getColumnIndex("floatData")
                var dateData_pos = c.getColumnIndex("dateData")

                var idx = c.getInt(idx_pos)
                var textData = c.getString(textdata_pos)
                var intData = c.getInt(intData_pos)
                var floatData = c.getDouble(floatData_pos)
                var dateData = c.getString(dateData_pos)

                textView.append("idx : ${idx}\n")
                textView.append("textData : ${textData}\n")
                textView.append("intData : ${intData}\n")
                textView.append("floatDate : ${floatData}\n")
                textView.append("dateData : ${dateData}\n\n")
            }
            db.close()
        }

        button3.setOnClickListener { v ->
            val helper = DBHelper(this)
            val db = helper.writableDatabase

            val sql = "update TestTable set textData = ? where idx = ?"
            var arg = arrayOf("문자열3", "1")
            db.execSQL(sql, arg)
            db.close()
            textView.text = "수정완료"
        }

        button4.setOnClickListener { v ->
            val helper = DBHelper(this)
            val db = helper.writableDatabase

            val sql = "delete from TestTable where idx = ?"
            var arg = arrayOf("1")

            db.execSQL(sql, arg)
            db.close()
            textView.text = "삭제 완료"
        }
    }

}
