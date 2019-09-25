package com.example.mybukku.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class IndustryIdentifiersItem(

	@field:SerializedName("identifier")
	val identifier: String? = null,

	@field:SerializedName("type")
	val type: String? = null
) : Parcelable