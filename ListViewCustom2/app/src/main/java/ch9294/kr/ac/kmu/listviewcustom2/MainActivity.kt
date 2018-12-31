package ch9294.kr.ac.kmu.listviewcustom2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val imgRes = intArrayOf(
        R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3
        , R.drawable.imgflag5, R.drawable.imgflag6, R.drawable.imgflag7, R.drawable.imgflag8
    )
    val data1 = arrayOf("토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국")
    val data2 = arrayOf("togo", "france", "swiss", "spain", "japan", "german", "brazil", "korea")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list = ArrayList<HashMap<String, Any>>()

        var idx = 0

        for (idx in 0..(data1.size - 1)){
            var map = HashMap<String, Any>()
            map.put("flag", imgRes[idx])
            map.put("data1", data1[idx])
            map.put("data2", data2[idx])

            list.add(map)
        }
        val keys = arrayOf("flag", "data1", "data2")
        val ids = intArrayOf(R.id.imageView, R.id.textView2, R.id.textView3)

        val adapter = SimpleAdapter(this, list, R.layout.row, keys, ids)
        listView.adapter = adapter
    }
}
