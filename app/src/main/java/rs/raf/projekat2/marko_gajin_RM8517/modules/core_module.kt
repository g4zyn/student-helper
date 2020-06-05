package rs.raf.projekat2.marko_gajin_RM8517.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.local.LectureDatabase
import java.util.*
import java.util.concurrent.TimeUnit

val coreModule = module {

    single<SharedPreferences> {
        androidApplication().getSharedPreferences(androidApplication().packageName, Context.MODE_PRIVATE)
    }

    single { Room.databaseBuilder(androidContext(), LectureDatabase::class.java, "ScheduleDb")
        .fallbackToDestructiveMigration()
        .build() }

    single { createMoshi() }

    single { createOkHttpClient() }

    single { createRetrofit(moshi = get(), httpClient = get()) }
}

fun createMoshi(): Moshi {

    return Moshi.Builder()
        .add(Date::class.java, Rfc3339DateJsonAdapter())
        .build()
}

fun createRetrofit(moshi: Moshi, httpClient: OkHttpClient): Retrofit {

    return Retrofit.Builder()
        .baseUrl("https://rfidis.raf.edu.rs/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
        .client(httpClient)
        .build()
}

fun createOkHttpClient(): OkHttpClient {

    val httpClient = OkHttpClient.Builder()
    httpClient.readTimeout(60, TimeUnit.SECONDS)
    httpClient.connectTimeout(60, TimeUnit.SECONDS)
    httpClient.writeTimeout(60, TimeUnit.SECONDS)

    if (BuildConfig.DEBUG) {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(logging)
        httpClient.addNetworkInterceptor(StethoInterceptor())
    }

    return httpClient.build()
}

inline fun <reified T> create(retrofit: Retrofit): T {
    return retrofit.create<T>(T::class.java)
}