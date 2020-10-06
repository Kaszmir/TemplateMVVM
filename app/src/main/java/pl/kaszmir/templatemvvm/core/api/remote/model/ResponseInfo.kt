package pl.kaszmir.templatemvvm.core.api.remote.model


import com.google.gson.annotations.SerializedName

data class ResponseInfo(
    @SerializedName("count") val count: Int,
    @SerializedName("pages") val pages: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("prev") val prev: String?
) {
    companion object
}