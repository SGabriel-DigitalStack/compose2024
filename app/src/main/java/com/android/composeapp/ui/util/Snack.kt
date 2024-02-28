package com.android.composeapp.ui.util

import com.android.composeapp.model.Snack
import com.android.composeapp.model.snacks

fun getRandomSnack(): Snack {
  return snacks.random()
}

fun getRandomSnacks(count: Int): List<Snack> {
  return List(count) {
    snacks.random()
  }
}