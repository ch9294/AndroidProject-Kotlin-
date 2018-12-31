package ch9294.kr.ac.kmu.listviewcustom1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val data = arrayOf("data1", "data2", "data3", "data4", "data5", "data6", "data7")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)

        /*
        개발자가 직접 뷰의 모양을 만들었을 경우 layout 디렉토리에서 파일을 선택하고
        보여주고자하는 모양의 id를 직접 입력해주어야 한다.
         */

        /*
        하나의 뷰에 하나의 문자열만 Settting 할 때는 ArrayAdapter를 사용한다.
         */
        var adapter = ArrayAdapter(this, R.layout.row1, R.id.textView2, data)
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            textView.text = data[position]
        }
    }
}
