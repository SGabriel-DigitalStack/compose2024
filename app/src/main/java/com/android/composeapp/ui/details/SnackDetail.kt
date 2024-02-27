/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.composeapp.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.composeapp.model.Snack
import com.android.composeapp.model.snacks
import com.android.composeapp.ui.theme.JetsnackTheme

//****************
//**** README ****
//****************
// A cheat sheet with the needed components can be found here
// 📚 https://bit.ly/ComposeCheatSheet

// The workshop's description and hints can be found at
// 🔗 https://bit.ly/ComposeTraining2024Layouts


//***********************
//**** UI COMPONENTS ****
//***********************
// 🖼️ Images - UrlImage(...) /ui/components/UrlImage.kt
// ⚖️ Quantity selection - QuantitySelector(...) /ui/components/QuantitySelector.kt
// ⬅️ Back button - IconButton(...)
// 📏 Spacing - Spacer(...)
// 🚧 Dividing - Divider(...)
// 🔘 Button - Button(...) or JetsnackButton(...) /ui/components/Button.kt

//***************************************************
//**** USE THESE FOR SIZING THE MAIN UI ELEMENTS ****
//***************************************************
private val BottomBarHeight = 56.dp
private val ImageSize = 300.dp
private val HorizontalPadding = Modifier.padding(horizontal = 24.dp)

@Composable
fun SnackDetail(
  snack: Snack,
  backPress: () -> Unit
) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(White)
  ) {
    Text("Your solution here")
    //TODO implement your UI here
  }
}

@Preview("default", device = "id:pixel_7_pro")
@Composable
private fun SnackDetailPreview() {
  JetsnackTheme {
    SnackDetail(
      snack = snacks[0],
      backPress = { }
    )
  }
}

@Preview("default", device = "id:pixel_7_pro")
@Composable
private fun SnackDetailSolutionPreview() {
  JetsnackTheme {
    SnackDetailSolution(
      snack = snacks[0],
      backPress = { }
    )
  }
}
