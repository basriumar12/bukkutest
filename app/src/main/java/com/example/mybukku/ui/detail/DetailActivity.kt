package com.example.mybukku.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.mybukku.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val title = intent.getStringExtra("title")
        val author = intent.getStringExtra("author")
        val image = intent.getStringExtra("image")
        val desk = intent.getStringExtra("desk")


        book_title_text_view.text = title
        author_text_view.text = "Pengarang "+author
        book_desk_text_view.text = desk

        val options = RequestOptions()
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
            .dontAnimate()
            .dontTransform()
            .apply(RequestOptions.circleCropTransform())

        this?.let {
            Glide.with(this).setDefaultRequestOptions(options)
                .load(image)
                .into(front_cover_art_image_view)
        }

    }
}
