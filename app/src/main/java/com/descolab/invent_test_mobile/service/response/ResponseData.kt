package com.descolab.invent_test_mobile.service.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseData<T>(

	@field:SerializedName("status_code")
	val statusCode: String? = null,

	@field:SerializedName("status_message_ind")
	val statusMessageInd: String? = null,

	@field:SerializedName("status_message_eng")
	val statusMessageEng: String? = null,

	@field:SerializedName("value")
	val value: List<Product?>? = null
) : Parcelable


