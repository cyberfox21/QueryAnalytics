package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.domain.entity

/**
 * @author t.shkolnik
 */
data class FullInfo(
    val full: String,
    val graph: List<GraphPoint>,
    val pageFound: Boolean,
    val short: String
)
