package com.michaeljordanr.koombeatest.domain

import com.michaeljordanr.koombeatest.data.remote.UsersApi
import com.michaeljordanr.koombeatest.domain.model.User
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UsersApi
) : UserRepository {

    override suspend fun getUsers(): List<User> {
        return api.getUsers()
    }
}