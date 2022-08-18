package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPosts()

    }
    fun getPosts(){
        val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = apiClient.getPosts()

        request.enqueue(object : Callback<List<post>> {
            override fun onResponse(call: Call<List<post>>, response: Response<List<post>>) {
                if(response.isSuccessful){
                   val posts = response.body()
                   Toast.makeText(baseContext, "${posts!!.size} posts", Toast.
                   LENGTH_LONG).show()
            }}

            override fun onFailure(call: Call<List<post>>, t: Throwable) {
            }
        })
    }

fun displayPosts(postList: List<Post>){
    binding.rvPosts.layoutManager=LinearLayoutManager(this)
//    val postAdapter=PostRvAdapter(postList)
//    binding.rvPosts.adapter=postsAdapter

}
}



