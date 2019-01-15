package ch9294.kr.ac.kmu.sqlite1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper(context:Context) : SQLiteOpenHelper(context,"Test.db",null,1){

    /*
    프로그래머가 지정한 이름의 데이터베이스가 없을 경우에 onCreate 메소드를 실행하여 데이터베이스를 생성한다.
     */
    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("msg","DB onCreate")

        val sql = """
            create table TestTable(
            idx integer primary key autoincrement,
            textData text not null,
            intData integer not null,
            floatData real not null,
            dateData date not null)
        """.trimIndent()

        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d("msg","oldVersion : ${oldVersion} newVersion : ${newVersion}")
    }
}