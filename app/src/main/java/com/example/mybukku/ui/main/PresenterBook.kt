package com.example.mybukku.ui.main

import android.telecom.Call
import com.example.mybukku.ApiConfig
import com.example.mybukku.model.ItemsItem
import com.example.mybukku.model.ResponseBuku
import retrofit2.Response
import javax.security.auth.callback.Callback

class PresenterBook (val viewBook: ViewBook) {


    fun getData (){


        viewBook.showLoad()
        ApiConfig().instance().getBook("a").enqueue(object : retrofit2.Callback<ResponseBuku> {
            override fun onFailure(call: retrofit2.Call<ResponseBuku>, t: Throwable) {
                viewBook.message("Data gagal di load ")
                viewBook.hideLoad()
            }

            override fun onResponse(call: retrofit2.Call<ResponseBuku>, response: Response<ResponseBuku>) {

                if (response.isSuccessful){
                    viewBook.hideLoad()
                    viewBook.getData(response.body()?.items as List<ItemsItem>)
                } else{
                    viewBook.message("Data gagal di load ")
                    viewBook.hideLoad()
                }
            }
        })
    }

    fun getDataSearch ( keyword : String){
        viewBook.showLoad()
        ApiConfig().instance().getBook(keyword).enqueue(object : retrofit2.Callback<ResponseBuku> {
            override fun onFailure(call: retrofit2.Call<ResponseBuku>, t: Throwable) {
                viewBook.message("Data gagal di load ")
                viewBook.hideLoad()
            }

            override fun onResponse(call: retrofit2.Call<ResponseBuku>, response: Response<ResponseBuku>) {

                if (response.isSuccessful){
                    viewBook.hideLoad()
                    viewBook.getData(response.body()?.items as List<ItemsItem>)
                } else{
                    viewBook.message("Data gagal di load ")
                    viewBook.hideLoad()
                }
            }
        })

    }
}