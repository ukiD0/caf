package com.example.champ.models


@kotlinx.serialization.Serializable
data class Trans(
    var id: Int = 0,
    var date: String = "",
    var money: Float = 0f,
    var name_trans: String = "",
    var description: String = ""
)
