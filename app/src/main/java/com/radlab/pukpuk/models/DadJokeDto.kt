package com.radlab.pukpuk.models

import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

data class DadJokeDto(

    @SerializedName("type") var type: String? = null,
    @SerializedName("setup") var setup: String? = null,
    @SerializedName("punchline") var punchline: String? = null,
    @SerializedName("id") var id: Int? = null

)
fun Flow<DadJokeDto>.mapToJoke(): Flow<String> {
    return this.map { data ->
        "${data.setup}\n${data.punchline}"
    }
}
fun DadJokeDto.mapToJoke(): String {
    return "${this.setup}\n${this.punchline}"
}