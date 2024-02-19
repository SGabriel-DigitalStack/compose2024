package com.android.composeapp.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Placeholder(
  modifier: Modifier = Modifier
) {
  Canvas(
    modifier = modifier.fillMaxSize(),
    onDraw = {
      drawRect(
        color = Color.Magenta,
        size = size
      )
      drawLine(
        color = Color.White,
        start = Offset.Zero,
        end = Offset(size.width, size.height),
        strokeWidth = 8f
      )
      drawLine(
        color = Color.White,
        start = Offset(size.width, 0f),
        end = Offset(0f, size.height),
        strokeWidth = 8f
      )

      drawRect(
        color = Color.White,
        size = size,
        style = Stroke(
          width = 8f,
        )
      )
    }
  )

}

@Preview
@Composable
private fun PlaceholderPreview() {
  Box(modifier = Modifier.size(200.dp), contentAlignment = Alignment.Center) {
    Box(modifier = Modifier.size(80.dp)) {
      Placeholder()
    }
  }
}