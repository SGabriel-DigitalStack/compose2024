package com.android.composeapp.ui.modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

fun Modifier.task1Solution(): Modifier {
  return this
    .size(40.dp)
    .background(Color.Blue)
    .padding(4.dp)
    .border(2.dp, Color.Yellow)
    .clip(CircleShape)
    .background(Color.Red)
}

@Composable
fun Task2Solution() {
  Box(
    modifier = Modifier
      .size(100.dp)
      .background(Color.Gray),
    contentAlignment = Alignment.Center
  ) {
    Box(
      modifier = Modifier
        .fillMaxSize(0.25f)
        .background(Color.Red)
        .align(Alignment.TopStart)
    )
    Box(
      modifier = Modifier
        .fillMaxSize(0.25f)
        .background(Color.Blue)
        .align(Alignment.BottomEnd)
    )
    Box(
      modifier = Modifier
        .fillMaxSize(0.75f)
        .border(3.dp, Color.Black)
        .padding(8.dp)
        .background(Color.Yellow)
    )
  }
}