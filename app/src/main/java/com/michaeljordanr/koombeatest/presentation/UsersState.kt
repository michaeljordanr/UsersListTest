package com.michaeljordanr.koombeatest.presentation

import com.michaeljordanr.koombeatest.domain.model.User

data class UsersState(
    val isLoading: Boolean = false,
    val error: String = "",
    val users: List<User> = emptyList()
)