package ch9294.kr.ac.kmu.file

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var permission_list = arrayOf(
        android.Manifest.permission.READ_EXTERNAL_STORAGE,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    var path: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 외부 저장소까지의 절대 경로
        path = Environment.getExternalStorageDirectory().absolutePath +
                "/android/data/" + packageName

        checkPermission()

        var file = File(path)

        if (file.exists() == false) {
            file.mkdir()
        }
        /*
        내부 저장소는 권한이 필요없음
        어플리케이션의 자체 공간이기 때문에
        어플리케이션이 삭제되면 데이터도 같이 삭제가 된다.
        어디에 저장되었는지 알 수 없음

        내부 저장소는 어플리케이션마다 할당되는 양이 매우 적기 때문에 대용량 저장은 어렵다.
        openFileOutput, openFileInput 메소드를 이용한 것은 내부저장소
         */

        /*
        외부 저장소는 권한이 필요함
        외부 저장소 저장시 android/data/패키지명 폴더에 저장하면 애플리케이션 삭제 시 같이 삭제가 된다.
        그 외의 폴더는 유지됨
         */

        button.setOnClickListener { v ->
            try {
                var output = openFileOutput("myFile.dat", Context.MODE_PRIVATE)
                var dos = DataOutputStream(output)
                dos.writeInt(100)
                dos.writeDouble(33.33)
                dos.writeUTF("안녕하세요")
                dos.flush()
                dos.close()
                textView.text = "저장완료"
            } catch (e: Exception) {
                textView.text = e.printStackTrace().toString()
            }
        }

        button2.setOnClickListener { v ->
            try {
                var input = openFileInput("myFile.dat")
                var dis = DataInputStream(input)
                var value1 = dis.readInt()
                var value2 = dis.readDouble()
                var value3 = dis.readUTF()
                dis.close()

                textView.text = "value1 : ${value1}\n"
                textView.append("value2 : ${value2}\n")
                textView.append("value3 : ${value3}\n")
            } catch (e: Exception) {
                textView.text = e.printStackTrace().toString()
            }
        }

        button3.setOnClickListener { v ->
            try {
                var output = FileOutputStream("${path}/sdFile.dat")
                var dos = DataOutputStream(output)
                dos.writeInt(200)
                dos.writeDouble(22.22)
                dos.writeUTF("반갑습니다.")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        button4.setOnClickListener { v ->
            try {
                var input = FileInputStream("${path}/sdFile.dat")
                var dis = DataInputStream(input)

                var val1 = dis.readInt()
                var val2 = dis.readDouble()
                var val3 = dis.readUTF()

                textView.text = "val1 : ${val1}\n"
                textView.append("val2 : ${val2}\n")
                textView.append("val3 : ${val3}\n")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun checkPermission() {
        // 버전 체크
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return
        }

        for (permission in permission_list) {
            // 인자로 넘어온 권한이 허용되었는지 여부를 확인한다.
            var chk = checkCallingOrSelfPermission(permission)
            if (chk == PackageManager.PERMISSION_DENIED) {
                // 허용되지 않은 권한에 대한 허용 여부를 사용자에게 묻는다.
                requestPermissions(permission_list, 0)
            }
        }

    }
}
