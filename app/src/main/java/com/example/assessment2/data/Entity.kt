package com.example.assessment2.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Entity(
    @Json(name = "scientificName") val scientificName: String,
    @Json(name = "commonName") val commonName: String,
    @Json(name = "careLevel") val careLevel: String,
    @Json(name = "lightRequirement") val lightRequirement: String,
    @Json(name = "description") val description: String
) : Parcelable
