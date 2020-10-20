package com.example.mybukku.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

import com.example.mybukku.R
import com.example.mybukku.model.ItemsItem
import com.example.mybukku.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.item_book.view.*
import org.jetbrains.anko.db.NULL
import org.jetbrains.anko.startActivity
import java.text.NumberFormat
import java.util.*


// adapter sebagai manajamen list, class ini ada untuk setiap class pertanyaan
class BookAdapter(var context: Context?, var list: List<ItemsItem>) :
    RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    private var mOnItemClickListener: OnItemClickListener? = null
    private lateinit var uri: Uri

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    //    fun mActivity(activity: Activity) {
//        this.activity = activity
//    }
    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.mOnItemClickListener = mItemClickListener
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = list.get(position).volumeInfo?.title

        if (list.get(position).volumeInfo?.authors?.get(0).toString() != null) {

            holder.authors.text = "Pengarang : " + list.get(position).volumeInfo?.authors?.get(0).toString()

        }


        val localeID = Locale("in", "ID")
        var formatRupiah = NumberFormat.getCurrencyInstance(localeID)
        val price = list.get(position).saleInfo?.listPrice?.amount

        if (price != null) {
            holder.price.text = formatRupiah.format(price)

        }
        holder.rating.max = 5
        holder.rating.numStars = 5

        val rating = list.get(position).volumeInfo?.averageRating
        if (rating != null) {
            holder.rating.rating = rating.toFloat()

        }


        val options = RequestOptions()
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
            .dontAnimate()
            .dontTransform()
            .apply(RequestOptions.circleCropTransform())

        context?.let {
            Glide.with(it).setDefaultRequestOptions(options)
                .load(list.get(position).volumeInfo?.imageLinks?.thumbnail)
                .into(holder.image)
        }

        val data = list.get(position)

        holder.itemView.setOnClickListener {

            context?.startActivity<DetailActivity>(
                "title" to list.get(position).volumeInfo?.title
                ,
                "desk" to list.get(position).searchInfo?.textSnippet.toString()
                ,
                "image" to list.get(position).volumeInfo?.imageLinks?.thumbnail
                ,
                "author" to list.get(position).volumeInfo?.imageLinks?.thumbnail,
                 
                "data" to list.get(position).volumeInfo?.imageLinks?.thumbnail,
            )

        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(context).inflate(R.layout.item_book, p0, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.book_title_text_view
        val image = itemView.front_cover_art_image_view
        val rating = itemView.rating_bar
        val price = itemView.retail_price_text_view
        val authors = itemView.author_text_view


    }
}
