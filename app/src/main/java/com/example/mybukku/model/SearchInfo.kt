package com.example.mybukku.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class SearchInfo(

	@field:SerializedName("textSnippet")
	val textSnippet: String? = null
) : Parcelable