package ch9294.kr.ac.kmu.retrofitex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Response
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val thread = MyThread()
            thread.start()
        }
    }

    inner class MyThread : Thread() {
        override fun run() {
            val retrofit = Retrofit.Builder().baseUrl("https://api.github.com").build()
            val service = retrofit.create(GitHubService::class.java)
            val repos = service.listRepos("ch9294")

            for (r in repos) {
                val id = r.id
                val name = r.name
                val full = r.full_name
                val description = r.description

                val string = """
                    id : ${id}
                    name : ${name}
                    full : ${full}
                    description : ${description}
                """.trimIndent()

                Log.d("retrofit test", string)
            }
        }
    }

}

interface GitHubService {
    @GET("/users/{user}/repos")
    fun listRepos(@Path("user")
                  user: String): List<Repo>
}

class Repo(val id: Int, val name: String, val full_name: String, val description: String)
