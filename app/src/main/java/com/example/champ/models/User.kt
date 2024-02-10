package com.example.champ.models

@kotlinx.serialization.Serializable
data class  User(
    var id: Int = 0,
    var first_name: String = "",
    var last_name: String = "",
    var email: String = ""
)
