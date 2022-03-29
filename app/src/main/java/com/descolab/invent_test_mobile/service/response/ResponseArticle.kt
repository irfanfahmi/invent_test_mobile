package com.descolab.invent_test_mobile.service.responsee

import com.descolab.invent_test_mobile.service.response.ArticlesItem
import com.google.gson.annotations.SerializedName

data class ResponseArticle<T>(

    @field:SerializedName("totalResults")
    val totalResults: Int? = null,

    @field:SerializedName("articles")
    val articles: List<ArticlesItem?>? = null,

    @field:SerializedName("status")
    val status: String? = null
)