package com.example.shoestore

import android.content.Context
import android.widget.Toast

fun String.getDouble(): Double = try {
    toDouble()
} catch (e: NumberFormatException) {
    e.printStackTrace()
    0.0
}