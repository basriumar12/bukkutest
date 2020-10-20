package com.example.mybukku

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


// class ini fungsinya sama seperti class servicegenerator, base ketika menggunakan library
// retrofit2
class ApiConfig {



    val base_url = "https://www.googleapis.com/books/v1/"
    //add other baseurl
    //val base_url = "https://www.googleapis.com/books/v1/hk/"


    private fun retrofit() : Retrofit {


        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(base_url)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun instance() : ApiInterface {
        return retrofit().create(ApiInterface::class.java)
    }
}
