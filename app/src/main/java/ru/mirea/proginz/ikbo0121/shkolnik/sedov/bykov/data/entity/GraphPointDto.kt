package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity

import com.google.gson.annotations.SerializedName

/**
 * @author t.shkolnik
 */
data class GraphPointDto(
    @SerializedName("date")
    val date: String,
    @SerializedName("popularity")
    val popularity: Int
)
