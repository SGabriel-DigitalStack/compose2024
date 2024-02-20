package com.android.composeapp.ui.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.composeapp.model.Snack
import com.android.composeapp.model.snacks
import com.android.composeapp.ui.components.QuantitySelector
import com.android.composeapp.ui.components.UrlImage
import com.android.composeapp.ui.theme.JetsnackTheme
import com.android.composeapp.ui.util.formatPrice

@Composable
fun CartItem(
  snack: Snack,
  amount: Int,
  removeSnack: (Long) -> Unit,
  increaseItemCount: (Long) -> Unit,
  decreaseItemCount: (Long) -> Unit,
  onSnackClick: (Long) -> Unit,
  modifier: Modifier = Modifier
) {
  Box(
    modifier = Modifier
      .background(JetsnackTheme.colors.uiBackground)
      .clickable(onClick = { onSnackClick(snack.id) })
      .padding(16.dp),
  ) {
    Row(
      modifier = modifier
        .fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(8.dp),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      UrlImage(
        url = snack.imageUrl,
        contentDescription = null,
        modifier = Modifier
          .size(100.dp)
          .clip(CircleShape)
      )

      Column {
        Text(
          text = snack.name,
          style = JetsnackTheme.typography.subtitle1,
          color = JetsnackTheme.colors.textSecondary,
        )

        Text(
          text = snack.tagline,
          style = MaterialTheme.typography.body1,
          color = JetsnackTheme.colors.textHelp,
        )

        Spacer(
          Modifier
            .height(8.dp)
        )

        Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween,
          modifier = Modifier.fillMaxWidth()
        ) {
          Text(
            text = formatPrice(snack.price),
            style = MaterialTheme.typography.subtitle1,
            color = JetsnackTheme.colors.textPrimary,
          )
          QuantitySelector(
            count = amount,
            decreaseItemCount = { decreaseItemCount(snack.id) },
            increaseItemCount = { increaseItemCount(snack.id) },
          )
        }
      }
    }

    IconButton(
      onClick = { removeSnack(snack.id) },
      modifier = Modifier.align(Alignment.TopEnd)
    ) {
      Icon(
        imageVector = Icons.Filled.Close,
        tint = JetsnackTheme.colors.iconSecondary,
        contentDescription = "remove item"
      )
    }

  }
}

@Preview
@Composable
private fun CartItemPreview() {
  var count by remember { mutableIntStateOf(1) }
  JetsnackTheme {
    CartItem(
      snack = snacks[0],
      amount = count,
      removeSnack = {},
      increaseItemCount = { count++ },
      decreaseItemCount = { count-- },
      onSnackClick = {},
    )
  }
}