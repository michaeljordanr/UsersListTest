package com.michaeljordanr.koombeatest.domain

import com.michaeljordanr.koombeatest.domain.model.User

interface UserRepository {

    suspend fun getUsers(): List<User>
}