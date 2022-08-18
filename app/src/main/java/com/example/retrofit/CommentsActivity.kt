package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {
    var postId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)
    }

    fun obtainPostId() {
        postId = intent.extras?.getInt("POST_ID") ?: 0

    }

    fun fetchPosts() {
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostById(postId)
        request.enqueue(object : Callback<post> {
            override fun onResponse(call: Call<post>, response: Response<post>) {
                var post=response.body()
                if (post!=null){
//                    binding.tvPostTitle.text=post.title
//                    binding.tvPostBody.text=post.body
                }
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<post>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }



     fun onFailure(call: Call<post>, t: Throwable) {


    }
}