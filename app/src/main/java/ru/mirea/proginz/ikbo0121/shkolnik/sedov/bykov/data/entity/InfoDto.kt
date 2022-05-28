package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity

import com.google.gson.annotations.SerializedName

/**
 * @author t.shkolnik
 */
data class InfoDto(
    @SerializedName("full")
    val full: String,
    @SerializedName("page_found")
    val pageFound: Boolean,
    @SerializedName("short")
    val short: String
)
