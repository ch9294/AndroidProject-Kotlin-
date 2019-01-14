package ch9294.kr.ac.kmu.xml

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Element
import java.io.File
import java.lang.Exception
import java.net.URL
import javax.xml.parsers.DocumentBuilderFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text = ""

        button.setOnClickListener { v->
            NetworkThread().start()
        }

    }

    inner class NetworkThread : Thread() {
        override fun run() {
            try {
                val url = URL("http://13.125.170.17/Route.xml")
                val connect = url.openConnection()
                val input = connect.getInputStream()

                val factory = DocumentBuilderFactory.newInstance()
                val builder = factory.newDocumentBuilder()
                val doc = builder.parse(input)

                // xml 문서의 모든 내용을 가져온다
                val root = doc.documentElement
                val item_node_list = root.getElementsByTagName("Row")
                for (i in 0 until 5) {
                    val item_element = item_node_list.item(i) as Element

                    val data1_node_list = item_element.getElementsByTagName("노선번호")
                    val data2_node_list = item_element.getElementsByTagName("유형")
                    val data3_node_list = item_element.getElementsByTagName("종류")
                    val data4_node_list = item_element.getElementsByTagName("운행업체")

                    val data1 = data1_node_list.item(0)
                    val data2 = data2_node_list.item(0)
                    val data3 = data3_node_list.item(0)
                    val data4 = data4_node_list.item(0)

                    val text1 = data1.textContent
                    val text2 = data2.textContent
                    val text3 = data3.textContent
                    val text4 = data4.textContent

                    runOnUiThread {
                        textView.append("${text1}\n")
                        textView.append("${text2}\n")
                        textView.append("${text3}\n")
                        textView.append("${text4}\n")
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
