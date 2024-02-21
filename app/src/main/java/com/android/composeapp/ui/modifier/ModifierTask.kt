package com.android.composeapp.ui.modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(group = "task1")
@Composable
fun Task1Preview() {
  //TODO try to match the solution preview
}

@Preview(group = "task1")
@Composable
fun Task1PreviewSolution() {
  Box(Modifier.task1Solution())
}

@Preview(group = "task2")
@Composable
fun Task2Preview() {
  Box(
    modifier = Modifier
      .size(100.dp)
      .background(Color.Gray),
    contentAlignment = Alignment.Center
  ) {
    //TODO chain modifiers to achieve the solution in Task2SolutionPreview
    Box(Modifier)
    Box(Modifier)
    Box(Modifier)
  }
}

@Preview(group = "task2")
@Composable
fun Task2SolutionPreview() {
  Task2Solution()
}