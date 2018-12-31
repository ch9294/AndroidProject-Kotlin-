package ch9294.kr.ac.kmu.listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data = arrayOf("리스트1", "리스트2", "리스트3", "리스트4", "리스트5", "리스트6", "리스트7", "리스트8")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        context : 안드로이드에서는 기본적으로 this를 사용한다.
        resource : 안드로이드에서 기본적으로 제공하는 모양을 사용
         */
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        val adapter2 = ArrayAdapter(this,android.R.layout.simple_list_item_checked,data)
        listView.adapter = adapter2
        listView.setOnItemClickListener(ListListener())
    }

    inner class ListListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            textView.text = data[position]
        }
    }
}
