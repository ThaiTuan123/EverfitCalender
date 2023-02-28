package com.example.everfittest.di

import com.example.everfittest.data.service.ApiServices
import com.example.everfittest.utils.Constant
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { provideGson() }
    single { provideRetrofit(get(), get()) }
    single { createOkHttpClient() }
    single { provideAPIService(get()) }
}

private const val TIME_OUT = 30L

fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit? {
    return Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}

fun provideMovieRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit? {
    return Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}

private fun provideAPIService(retrofit: Retrofit): ApiServices {
    return retrofit.create(ApiServices::class.java)
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}