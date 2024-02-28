package com.android.composeapp.ui.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.ColorUtils

fun getTonedColor(base: Color, lightness: Float): Color {
  val hslOut = floatArrayOf(0f, 0f, 0f)
  ColorUtils.colorToHSL(base.toArgb(), hslOut)
  // we don't want darker tones
  val mappedLightness = 0.5f + 0.5f * lightness
  return Color.hsl(hslOut[0], hslOut[1], mappedLightness)
}