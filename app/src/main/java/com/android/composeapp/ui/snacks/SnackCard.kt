package com.android.composeapp.ui.snacks

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.composeapp.common.Placeholder
import com.android.composeapp.model.Snack
import com.android.composeapp.model.snacks
import com.android.composeapp.ui.theme.JetsnackTheme

@Composable
fun SnackCard(
  snack: Snack,
  modifier: Modifier = Modifier
) {
  //TODO implement Snack card (see details in README.md over on GitHub)
  Placeholder(modifier.size(148.dp, 200.dp))
}

@Preview
@Composable
private fun SnackCardPreview() {
  JetsnackTheme {
    SnackCard(snacks[0])
  }
}