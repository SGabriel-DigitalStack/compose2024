package com.android.composeapp.ui.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.composeapp.model.OrderItem
import com.android.composeapp.model.snacks
import com.android.composeapp.ui.theme.JetsnackTheme
import com.android.composeapp.ui.util.formatPercent
import com.android.composeapp.ui.util.formatPrice
import kotlin.math.roundToLong

private val initialOrder = arrayOf(
  snacks[0].id to OrderItem(snacks[0], 2),
  snacks[1].id to OrderItem(snacks[1], 1)
)

@Composable
fun CartScreen() {
  val cartContent = remember { mutableStateMapOf(*initialOrder) }
  val subtotal = cartContent.values.sumOf { it.count * it.snack.price }
  val itemCount = cartContent.values.size
  val tipsPercent = remember { mutableStateOf(0f) }
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(JetsnackTheme.colors.uiBackground)
  ) {
    Text(
      text = "Order $itemCount",
      style = MaterialTheme.typography.h6,
      color = JetsnackTheme.colors.brand,
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
      modifier = Modifier
        .heightIn(min = 56.dp)
        .padding(horizontal = 24.dp, vertical = 4.dp)
        .wrapContentHeight()
    )

    cartContent.values.forEach { orderItem ->
      CartItem(
        snack = orderItem.snack,
        amount = orderItem.count,
        removeSnack = { snackId -> cartContent.remove(snackId) },
        increaseItemCount = { snackId ->
          val item = cartContent[snackId] ?: throw IllegalStateException("No snack with $snackId")
          cartContent[snackId] = item.copy(count = item.count + 1)
        },
        decreaseItemCount = { snackId ->
          val item = cartContent[snackId] ?: throw IllegalStateException("No snack with $snackId")
          cartContent[snackId] = item.copy(count = item.count - 1)
        },
        onSnackClick = {},
      )
    }

    Column {
      Text(
        text = "Summary",
        style = MaterialTheme.typography.h6,
        color = JetsnackTheme.colors.brand,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
          .padding(horizontal = 24.dp)
          .heightIn(min = 56.dp)
          .wrapContentHeight()
      )
      Row(modifier = Modifier.padding(horizontal = 24.dp)) {
        Text(
          text = "Subtotal",
          style = MaterialTheme.typography.body1,
          modifier = Modifier
            .weight(1f)
            .wrapContentWidth(Alignment.Start)
            .alignBy(LastBaseline)
        )
        Text(
          text = formatPrice(subtotal),
          style = MaterialTheme.typography.body1,
          modifier = Modifier.alignBy(LastBaseline)
        )
      }

      Row(modifier = Modifier.padding(horizontal = 24.dp)) {
        Text(
          text = "Tips",
          style = MaterialTheme.typography.body1,
          modifier = Modifier
            .weight(1f)
            .wrapContentWidth(Alignment.Start)
            .alignBy(LastBaseline)
        )
        Text(
          text = formatPercent(tipsPercent.value),
          style = MaterialTheme.typography.body1,
          modifier = Modifier.alignBy(LastBaseline)
        )
      }

      Spacer(modifier = Modifier.height(8.dp))
      TipsSlider(
        tipsPercent = tipsPercent.value,
        onValueChange = { tipsPercent.value = it }
      )
      Spacer(modifier = Modifier.height(8.dp))

      Row(modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)) {
        Text(
          text = "Total",
          style = MaterialTheme.typography.body1,
          modifier = Modifier
            .weight(1f)
            .padding(end = 16.dp)
            .wrapContentWidth(Alignment.End)
            .alignBy(LastBaseline)
        )
        val tips = (tipsPercent.value * subtotal).roundToLong()
        Text(
          text = formatPrice(subtotal + tips),
          style = MaterialTheme.typography.subtitle1,
          modifier = Modifier.alignBy(LastBaseline)
        )
      }
    }
  }
}

@Composable
private fun TipsSlider(tipsPercent: Float, onValueChange: (Float) -> Unit) {
  Slider(
    value = tipsPercent,
    onValueChange = onValueChange,
    valueRange = 0f..0.3f,
    steps = 5,
    colors = SliderDefaults.colors(
      thumbColor = JetsnackTheme.colors.brand,
      activeTrackColor = JetsnackTheme.colors.brand,
      inactiveTrackColor = JetsnackTheme.colors.brand.copy(alpha = 0.7f),
      activeTickColor = Color.White,
      inactiveTickColor = JetsnackTheme.colors.brand,
    ),
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 24.dp)
  )
}

@Preview
@Composable
private fun CartScreenPreview() {
  JetsnackTheme {
    CartScreen()
  }
}