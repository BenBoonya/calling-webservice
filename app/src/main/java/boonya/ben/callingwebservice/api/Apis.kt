package com.ben.boonya.architecturecomponentdemo.common.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Boonya Kitpitak on 6/16/17.
 */
object Apis {
    public fun getStarWarApi(): Swapi {
        val gson = GsonBuilder ().create()
        val retrofit = Retrofit.Builder()
                .baseUrl("http://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        return  retrofit.create(Swapi::class.java)
    }
}