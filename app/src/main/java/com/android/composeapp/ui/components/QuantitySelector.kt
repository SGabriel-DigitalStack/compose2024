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

package com.android.composeapp.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.composeapp.ui.theme.JetsnackTheme

@Composable
fun QuantitySelector(
  count: Int,
  decreaseItemCount: () -> Unit,
  increaseItemCount: () -> Unit,
  modifier: Modifier = Modifier
) {
  Row(
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      text = "Qty",
      style = MaterialTheme.typography.subtitle1,
      color = JetsnackTheme.colors.textSecondary,
      modifier = Modifier
        .padding(end = 18.dp)
        .align(Alignment.CenterVertically)
    )

    if (count > 1) {
      JetsnackGradientTintedIconButton(
        imageVector = Icons.Default.Remove,
        onClick = decreaseItemCount,
        contentDescription = "decrease",
        modifier = Modifier.align(Alignment.CenterVertically)
      )
    }

    Text(
      text = count.toString(),
      style = MaterialTheme.typography.subtitle2,
      fontSize = 18.sp,
      color = JetsnackTheme.colors.textPrimary,
      textAlign = TextAlign.Center,
      modifier = Modifier.widthIn(min = 24.dp)
    )

    JetsnackGradientTintedIconButton(
      imageVector = Icons.Default.Add,
      onClick = increaseItemCount,
      contentDescription = "increase",
      modifier = Modifier.align(Alignment.CenterVertically)
    )
  }
}

@Preview("default")
@Preview("dark theme", uiMode = UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
fun QuantitySelectorPreview() {
  JetsnackTheme {
    Surface(
      color = JetsnackTheme.colors.uiBackground,
    ) {
      QuantitySelector(1, {}, {})
    }
  }
}
