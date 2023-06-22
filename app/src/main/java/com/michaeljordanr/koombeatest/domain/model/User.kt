package com.michaeljordanr.koombeatest.domain.model


data class User(
    val birthday: String,
    val email: String,
    val firstName: String,
    val gender: String,
    val id: Int,
    val lastName: String,
    val phone: String,
    val pictureURL: String,
    val twitterHandle: String,
    val username: String
)