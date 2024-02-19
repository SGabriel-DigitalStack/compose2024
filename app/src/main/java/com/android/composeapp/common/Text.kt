package com.android.composeapp.common

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum

fun generateLoremIpsum(count: Int): String {
  return LoremIpsum(count).values.joinToString(separator = " ")
}