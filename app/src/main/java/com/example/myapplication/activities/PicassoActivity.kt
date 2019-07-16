package com.example.myapplication.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picasso.*
import java.lang.Exception

class PicassoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)
        buttonLoader.setOnClickListener { loadImages() }
        Picasso.get().load("https://physicsworld.com/wp-content/uploads/2019/05/NGC_2419-1024x532.jpg").fetch()
    }

    private fun loadImages() {
        Picasso
            .get()
            .load("https://physicsworld.com/wp-content/uploads/2019/05/NGC_2419-1024x532.jpg")
            .resize(350, 350)
            .centerInside()
            .into(imageViewTop)
        val context: Context = this
        Picasso
            .get()
            .load("https://image.flaticon.com/icons/png/512/25/25657.png")
            .fetch(object : Callback {
                override fun onSuccess() {
                    imageViewBottom.alpha = 0f
                    Picasso.get().load("https://image.flaticon.com/icons/png/512/25/25657.png")
                        .transform(CircleTransform())
                        .into(imageViewBottom)
                    imageViewBottom.animate().setDuration(1000).alpha(1f).start()
                }

                override fun onError(e: Exception?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })

    }

}
