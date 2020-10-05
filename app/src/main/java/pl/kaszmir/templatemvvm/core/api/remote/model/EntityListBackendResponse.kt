package pl.kaszmir.templatemvvm.core.api.remote.model

import com.google.gson.annotations.SerializedName

data class EntityListBackendResponse<T>(
    @SerializedName("info")
    val info: ResponseInfo,

    @SerializedName("results")
    val result: List<T>
) {
    companion object {

    }
}