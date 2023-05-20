package com.example.sopthactaton.api

import android.util.Log
import com.example.sopthactaton.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object ApiFactory {

    val json = Json(){
        ignoreUnknownKeys = true
    }
    private fun getLogOkHttpClient(): Interceptor {

        val interceptor = HttpLoggingInterceptor { message ->
            when {
                message.isJsonObject() ->
                    Log.d("Retrofit2", JSONObject(message).toString(4))
                message.isJsonArray() ->
                    Log.d("Retrofit2", JSONArray(message).toString(4))
                else -> {
                    Log.d("Retrofit2", "CONNECTION INFO -> $message")
                }
            }
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun String?.isJsonObject(): Boolean = this?.startsWith("{") == true && this.endsWith("}")
    fun String?.isJsonArray(): Boolean = this?.startsWith("[") == true && this.endsWith("]")

    private val client = OkHttpClient.Builder()
        .addInterceptor(getLogOkHttpClient())
        .connectTimeout(100, TimeUnit.SECONDS)
        .readTimeout(100,TimeUnit.SECONDS)
        .writeTimeout(100, TimeUnit.SECONDS)
        .build()

    val testAPI: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BuildConfig.SOPT_BASE_URL)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .client(client).build()
    }

    inline fun <reified T> createAuthService(): T = testAPI.create<T>(T::class.java)

}

object ServicePool {
    val testService = ApiFactory.createAuthService<TestApiService>()
    val accuseService = ApiFactory.createAuthService<AccuseApiService>()
}