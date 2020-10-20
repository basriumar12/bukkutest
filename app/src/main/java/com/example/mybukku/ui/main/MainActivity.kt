package com.example.mybukku.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.mybukku.R
import com.example.mybukku.base.BaseActivity
import com.example.mybukku.model.ItemsItem
import com.utsman.recycling.setupAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_book.*
import kotlinx.android.synthetic.main.item_book.view.*
import java.text.NumberFormat
import java.util.*
import android.content.res.Configuration


class MainActivity : BaseActivity(), ViewBook {
    override fun showLoad() {
        showProgressDialog("Load data buku")

    }

    override fun hideLoad() {

        dismissProgressDialog()
    }

    override fun message(message: String) {

        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun getData(allData: List<ItemsItem>) {
        dataBook.clear()
        dataBook.addAll(allData)
        val adapter = BookAdapter(this, dataBook)
        rv_book.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    var dataBook = mutableListOf<ItemsItem>()

    val localeID = Locale("in", "ID")


    var presenterBook = PresenterBook(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.mybukku.R.layout.activity_main)

        presenterBook = PresenterBook(this)
        presenterBook.getData()

        initView()
        getSearch()


    }

    private fun initView() {
        ///get data
        rv_book.layoutManager = GridLayoutManager(this, 1)
        val orientation = this.resources.configuration.orientation
        // Set span count based on orientation
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            rv_book.setLayoutManager(GridLayoutManager(this, 2))
        } else {
            rv_book.setLayoutManager(GridLayoutManager(this, 3))
        }


//
//        rv_book.setupAdapter<ItemsItem>(R.layout.item_book) { adapter, context, list ->
//            bind { itemView, position, item ->
//
//
//                setLayoutManager(GridLayoutManager(context,2))
//
//                val options = RequestOptions()
//                    .fitCenter()
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .priority(Priority.HIGH)
//                    .dontAnimate()
//                    .dontTransform()
//                    .apply(RequestOptions.circleCropTransform())
//
//                Glide.with(this@MainActivity).setDefaultRequestOptions(options)
//                    .load(dataBook.get(position).volumeInfo?.imageLinks?.thumbnail)
//                    .into(itemView.front_cover_art_image_view)
//
//                itemView.book_title_text_view.text = dataBook.get(position).volumeInfo?.title
//                itemView.author_text_view.text = dataBook.get(position).volumeInfo?.authors?.get(0).toString()
//
//
//
//                var formatRupiah = NumberFormat.getCurrencyInstance(localeID)
//                itemView.retail_price_text_view.text = formatRupiah.format(dataBook.get(position).saleInfo?.listPrice?.amount)
//
//                itemView.rating_bar.max = 5
//                itemView.rating_bar.numStars = 5
//                itemView.rating_bar.rating = dataBook.get(position).volumeInfo?.averageRating?.toFloat()!!
//
//
//
//            }
//            submitList(dataBook)
//
//        }
    }

    private fun getSearch() {
        search_book.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                presenterBook.getDataSearch(query.toString())
                return true
            }

        })
    }
}
