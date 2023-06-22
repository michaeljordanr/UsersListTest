package com.michaeljordanr.koombeatest.data.remote

import com.michaeljordanr.koombeatest.domain.model.User
import retrofit2.http.GET

interface UsersApi {

    @GET("/users")
    suspend fun getUsers(): List<User>

}