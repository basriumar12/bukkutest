package com.example.mybukku.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseBuku(

	@field:SerializedName("totalItems")
	val totalItems: Int? = null,

	@field:SerializedName("kind")
	val kind: String? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null
) : Parcelable