package app.dheeraj.okhttppost

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    val posturl ="https://ptsv2.com/t/wzwc5-1553337903/post"
    val student= Student("dheeraj","android",18)
    val gson =Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    val client = OkHttpClient()
        val media =MediaType.parse("application/json")
        val studentjson= gson.toJson(student)
        val requestBody =RequestBody.create(media,studentjson)
        val request= Request.Builder().url(posturl).post(requestBody).header("First","Success").build()
        client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {
              e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                Log.e("Tag",response.body()?.string())
            }
        })
    }
}
