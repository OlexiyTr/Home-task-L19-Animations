package com.example.home_task_l19

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserInfo(
    val firstName : String,
    val secondName : String,
    val description : String,
    val imageUrl : String

) : Parcelable