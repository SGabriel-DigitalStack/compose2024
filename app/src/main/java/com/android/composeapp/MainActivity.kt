package com.android.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.composeapp.model.snacks
import com.android.composeapp.ui.snacks.SnackCard
import com.android.composeapp.ui.theme.JetsnackTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      JetsnackTheme {
        SnackGrid()
      }
    }
  }
}

@Composable
fun SnackGrid() {
  LazyVerticalGrid(
    columns = GridCells.Adaptive(148.dp),
    modifier = Modifier
      .fillMaxSize()
      .background(JetsnackTheme.colors.uiFloated),
    contentPadding = PaddingValues(8.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    items(snacks) { snack ->
      SnackCard(snack)
    }
  }
}


@Preview
@Composable
private fun SnackGridPreview() {
  JetsnackTheme {
    SnackGrid()
  }
}