package com.example.mybukku.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PanelizationSummary(

	@field:SerializedName("containsImageBubbles")
	val containsImageBubbles: Boolean? = null,

	@field:SerializedName("containsEpubBubbles")
	val containsEpubBubbles: Boolean? = null
) : Parcelable