package com.example.shoestore.models

import android.os.Parcelable
import com.example.shoestore.getDouble
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String, var size: Double, var company: String, var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable {

    var sizeString: String
        get() = "0.0"
        set(value) {
            size = value.getDouble()
        }


}