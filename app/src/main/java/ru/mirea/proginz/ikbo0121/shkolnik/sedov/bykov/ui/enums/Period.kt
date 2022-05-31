package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.enums

import androidx.annotation.StringRes
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.R

enum class Period(@StringRes uiNameRes: Int) {
    LAST_5_YEARS(R.string.last_5_years),
    LAST_YEAR(R.string.last_year),
    LAST_3_MONTHS(R.string.last_3_months),
    LAST_MONTH(R.string.last_month),
    LAST_WEEK(R.string.last_week),
    LAST_DAY(R.string.last_day),
    LAST_4_HOURS(R.string.last_4_hours),
    LAST_HOUR(R.string.last_hour)
}