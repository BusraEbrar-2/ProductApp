package com.busra.productapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity (tableName = "product")
data class  Product (

    @PrimaryKey(autoGenerate = true  )
    val id : Int= 0 ,
    val name : String,
    val price :Double,
    val imageResId  : Int

) : Parcelable

