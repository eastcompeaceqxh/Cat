package com.xinghai.kotlin.catio.api

import com.xinghai.kotlin.catio.data.CatDetailResult
import com.xinghai.kotlin.catio.data.CatListResult
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApiService {

    /*
    apiKey	[long]	是	apiKey，申请数据后可在控制台查看
    page	[int]	否	页码（默认为1）
    pageSize	[int]	否	当前页面猫咪数目（默认为30）
     */
    @GET("/common/catFamily/queryCatList")
    suspend fun getCatList(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        @Query("apiKey") apiKey: String = ""
    ) : CatListResult

    /*
    apiKey	[long]	是	apiKey，申请数据后可在控制台查看
    petID	[int]	是	猫猫ID
     */
    @GET("/common/catFamily/queryCatInfo")
    suspend fun getCatDetail(
        @Query("petID") petID: String,
        @Query("apiKey") apiKey: String = ""
    ) : CatDetailResult

    companion object {
        const val BASE_URL = "https://api.apishop.net"

        fun create() : CatApiService  {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CatApiService::class.java)
        }

    }

}