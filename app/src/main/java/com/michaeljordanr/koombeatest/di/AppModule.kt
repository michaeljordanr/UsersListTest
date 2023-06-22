package com.michaeljordanr.koombeatest.di

import com.michaeljordanr.koombeatest.common.Constants
import com.michaeljordanr.koombeatest.data.remote.UsersApi
import com.michaeljordanr.koombeatest.domain.UserRepository
import com.michaeljordanr.koombeatest.domain.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUsersApi() : UsersApi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UsersApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: UsersApi): UserRepository {
        return UserRepositoryImpl(api)
    }
}