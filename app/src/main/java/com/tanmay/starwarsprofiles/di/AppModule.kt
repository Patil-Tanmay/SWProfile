package com.tanmay.starwarsprofiles.di

import android.content.Context
import androidx.room.Room
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tanmay.starwarsprofiles.data.db.StarWarsDatabase
import com.tanmay.starwarsprofiles.data.network.StarWarsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    private const val baseUrl = "https://swapi.dev/api/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .readTimeout(120, TimeUnit.SECONDS)
            .connectTimeout(120, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    }

    @Provides
    @Singleton
    fun provideQuotesAPi(retrofit: Retrofit): StarWarsApi =
        retrofit.create(StarWarsApi::class.java)



    @Provides
    @Singleton
    fun provideAppContext(@ApplicationContext context: Context):
            Context = context


    @Provides
    @Singleton
    fun provideStarWarsDb(@ApplicationContext context: Context): StarWarsDatabase {
        return Room.databaseBuilder(
            context,
            StarWarsDatabase::class.java,
            "CartDatabase"
        ).build()
    }

}
