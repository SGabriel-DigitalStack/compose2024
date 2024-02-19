package com.android.composeapp.ui.details

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.composeapp.model.Snack
import com.android.composeapp.model.snacks
import com.android.composeapp.ui.theme.JetsnackTheme


@Composable
fun SnackDetailsScreen(
  snack: Snack
) {
  //TODO implement snack details screen (see details in README.md over on GitHub)
}

@Preview
@Composable
private fun SnackDetailsScreenPreview() {
  JetsnackTheme {
    SnackDetailsScreen(snacks[0])
  }
}