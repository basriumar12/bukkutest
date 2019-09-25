package com.example.mybukku.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RetailPrice(

	@field:SerializedName("amount")
	val amount: Double? = null,

	@field:SerializedName("currencyCode")
	val currencyCode: String? = null,

	@field:SerializedName("amountInMicros")
	val amountInMicros: Double? = null
) : Parcelable