package com.android.composeapp.ui.util

import androidx.annotation.FloatRange
import java.math.BigDecimal
import java.text.NumberFormat

fun formatPrice(price: Long): String {
  return NumberFormat.getCurrencyInstance().format(
    BigDecimal(price).movePointLeft(2)
  )
}

fun formatPercent(@FloatRange(from = 0.0, to = 1.0) percent: Float): String {
  return String.format("%.2f%%", percent * 100)
}