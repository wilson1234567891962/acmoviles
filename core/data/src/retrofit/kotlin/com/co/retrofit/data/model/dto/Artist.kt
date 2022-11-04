package com.co.retrofit.data.model.dto

import com.google.gson.annotations.SerializedName

class Artist (
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("birthDate")
    val birthDate: String,
    @SerializedName("albums")
    val albums: List<Album>,

        )