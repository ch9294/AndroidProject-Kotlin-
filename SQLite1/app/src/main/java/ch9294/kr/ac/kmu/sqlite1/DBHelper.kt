package ch9294.kr.ac.kmu.sqlite1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper(context:Context) : SQLiteOpenHelper(context,"Test.db",null,1){
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