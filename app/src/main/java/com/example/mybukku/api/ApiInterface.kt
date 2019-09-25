package com.example.mybukku

import com.example.mybukku.model.ResponseBuku
import retrofit2.Call
import retrofit2.http.*


// class ini base endpoint ketika menggunakan library retrofit
interface ApiInterface {

    @GET("volumes")
    fun getBook (@Query("q")keyword :String) : Call<ResponseBuku>



}