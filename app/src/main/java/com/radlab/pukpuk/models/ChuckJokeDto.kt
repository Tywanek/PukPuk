package com.radlab.pukpuk.models

import com.google.gson.annotations.SerializedName

data class ChuckJokeDto (

    @SerializedName("icon_url" ) var iconUrl : String? = null,
    @SerializedName("id"       ) var id      : String? = null,
    @SerializedName("url"      ) var url     : String? = null,
    @SerializedName("value"    ) var value   : String? = null

)