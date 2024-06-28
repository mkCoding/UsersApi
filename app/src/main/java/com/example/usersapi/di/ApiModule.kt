package com.example.usersapi.di

import com.example.usersapi.data.api.ApiDetails
import com.example.usersapi.data.api.ApiEndpoints
import com.example.usersapi.data.repository.ApiRepository
import com.example.usersapi.data.repository.ApiRepositoryImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    //Provide all injections that will be used throughout the app

    //retrofit instance
    @Provides
    fun providesRetrofit():Retrofit{
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()

        //base url
        //client
        //converter factory
        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }

    //ApiEndpoints instance
    @Provides
    fun provideApiEndpoints(retrofit: Retrofit):ApiEndpoints{
        return retrofit.create(ApiEndpoints::class.java)
    }

    //ApiRepository instance
    @Provides
    fun providesRepository(apiEndpoints: ApiEndpoints):ApiRepository{
        return ApiRepositoryImpl(apiEndpoints)
    }
}