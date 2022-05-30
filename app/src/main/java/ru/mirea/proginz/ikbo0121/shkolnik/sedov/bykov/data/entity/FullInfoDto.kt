package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity

import com.google.gson.annotations.SerializedName

/**
 * @author t.shkolnik
 */
data class FullInfoDto(
    @SerializedName("full")
    val full: String,
    @SerializedName("graph")
    val graph: List<GraphPointDto>,
    @SerializedName("page_found")
    val pageFound: Boolean,
    @SerializedName("short")
    val short: String
)
