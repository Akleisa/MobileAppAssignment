package com.example.assessment2.network

import android.os.Parcel
import android.os.Parcelable

// Data class for the plant entity with Parcelable implementation
data class Plant(
    val scientificName: String,
    val commonName: String,
    val careLevel: String,
    val lightRequirement: String,
    val description: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(scientificName)
        parcel.writeString(commonName)
        parcel.writeString(careLevel)
        parcel.writeString(lightRequirement)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Plant> {
        override fun createFromParcel(parcel: Parcel): Plant {
            return Plant(parcel)
        }

        override fun newArray(size: Int): Array<Plant?> {
            return arrayOfNulls(size)
        }
    }
}
