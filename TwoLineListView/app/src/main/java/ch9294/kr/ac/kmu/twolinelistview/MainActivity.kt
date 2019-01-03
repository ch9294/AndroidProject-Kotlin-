package ch9294.kr.ac.kmu.twolinelistview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data1 = arrayOf("문자열1", "문자열2", "문자열3", "문자열4", "문자열5")
    var data2 = arrayOf("string1", "string2", "string3", "string4", "string5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = arrayListOf<Map<String, String>>()

//        var list = ArrayList<HashMap<String, String>>()
//        var idx = 0
//        while (idx < data1.size) {
//            var map = HashMap<String, String>()
//            map.put("str1", data1[idx])
//            map.put("str2", data2[idx])
//            list.add(map)
//            idx++
//        }

        for (idx in 0..(data1.size - 1)) {
            var map = mapOf<String, String>("str1" to data1[idx], "str2" to data2[idx])
            list.add(map)
        }

        val key = arrayOf("str1", "str2")
        val ids = intArrayOf(android.R.id.text1, android.R.id.text2)
        val adapter = SimpleAdapter(this, list, android.R.layout.simple_expandable_list_item_2, key, ids)

        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            textView.text = "$id : ${data1[position]+","+data2[position]}"
        }
    }
}
