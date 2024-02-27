package com.android.composeapp.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.composeapp.common.generateIngredients
import com.android.composeapp.common.generateLoremIpsum
import com.android.composeapp.model.Snack
import com.android.composeapp.model.snacks
import com.android.composeapp.ui.components.JetsnackButton
import com.android.composeapp.ui.components.JetsnackDivider
import com.android.composeapp.ui.components.JetsnackSurface
import com.android.composeapp.ui.components.QuantitySelector
import com.android.composeapp.ui.components.UrlImage
import com.android.composeapp.ui.theme.JetsnackTheme
import com.android.composeapp.ui.theme.Neutral8
import com.android.composeapp.ui.util.formatPrice

private val BottomBarHeight = 56.dp
private val ImageSize = 300.dp
private val HorizontalPadding = Modifier.padding(horizontal = 24.dp)

@Composable
fun SnackDetailSolution(
  snack: Snack,
  backPress: () -> Unit
) {
  Box(
    Modifier
      .fillMaxSize()
      .background(JetsnackTheme.colors.uiBackground)
  ) {
    val scrollState = rememberScrollState()
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(scrollState)
    ) {
      Spacer(Modifier.height(24.dp))

      Image(
        snack.imageUrl,
        modifier = Modifier.align(Alignment.CenterHorizontally)
      )
      Title(snack)
      Body()
    }
    Back(backPress)
    CartBottomBar(modifier = Modifier.align(Alignment.BottomCenter))
  }
}

@Composable
private fun Back(upPress: () -> Unit) {
  Icons.Filled
  Icons.Outlined
  Icons.Rounded
  Icons.Sharp
  Icons.TwoTone
  IconButton(
    onClick = upPress,
    modifier = Modifier
      .statusBarsPadding()
      .padding(horizontal = 16.dp, vertical = 10.dp)
      .size(36.dp)
      .background(
        color = Neutral8.copy(alpha = 0.32f),
        shape = CircleShape
      )
  ) {
    Icon(
      imageVector = Icons.Default.ChevronLeft,
      tint = JetsnackTheme.colors.iconInteractive,
      contentDescription = "back"
    )
  }
}

@Composable
private fun Body(
) {
  JetsnackSurface(Modifier.fillMaxWidth()) {
    Column {
      Spacer(Modifier.height(16.dp))
      Text(
        text = "Details",
        style = MaterialTheme.typography.overline,
        color = JetsnackTheme.colors.textHelp,
        modifier = HorizontalPadding
      )
      Spacer(Modifier.height(16.dp))
      var seeMore by remember { mutableStateOf(true) }
      val placeholderDetail = remember { generateLoremIpsum(50) }
      Text(
        text = placeholderDetail,
        style = MaterialTheme.typography.body1,
        color = JetsnackTheme.colors.textHelp,
        maxLines = if (seeMore) 5 else Int.MAX_VALUE,
        overflow = TextOverflow.Ellipsis,
        modifier = HorizontalPadding
      )
      val textButton = if (seeMore) {
        "SEE MORE"
      } else {
        "SEE LESS"
      }
      Text(
        text = textButton,
        style = MaterialTheme.typography.button,
        textAlign = TextAlign.Center,
        color = JetsnackTheme.colors.textLink,
        modifier = Modifier
          .heightIn(20.dp)
          .fillMaxWidth()
          .padding(top = 15.dp)
          .clickable {
            seeMore = !seeMore
          }
      )
      Spacer(Modifier.height(40.dp))
      Text(
        text = "Ingredients",
        style = MaterialTheme.typography.overline,
        color = JetsnackTheme.colors.textHelp,
        modifier = HorizontalPadding
      )
      Spacer(Modifier.height(4.dp))
      val ingredients = remember { generateIngredients(5) }
      Text(
        text = ingredients,
        style = MaterialTheme.typography.body1,
        color = JetsnackTheme.colors.textHelp,
        modifier = HorizontalPadding
      )

      Spacer(Modifier.height(16.dp))

      Spacer(
        modifier = Modifier
          .padding(bottom = BottomBarHeight)
          .navigationBarsPadding()
          .height(8.dp)
      )
    }
  }
}

@Composable
private fun Title(snack: Snack) {
  Column(
    verticalArrangement = Arrangement.Bottom,
    modifier = Modifier
      .statusBarsPadding()
      .background(color = JetsnackTheme.colors.uiBackground)
  ) {
    Spacer(Modifier.height(16.dp))
    Text(
      text = snack.name,
      style = JetsnackTheme.typography.h4,
      color = JetsnackTheme.colors.textSecondary,
      modifier = HorizontalPadding
    )
    Text(
      text = snack.tagline,
      style = MaterialTheme.typography.subtitle2,
      fontSize = 20.sp,
      color = JetsnackTheme.colors.textHelp,
      modifier = HorizontalPadding
    )
    Spacer(Modifier.height(4.dp))
    Text(
      text = formatPrice(snack.price),
      style = MaterialTheme.typography.h6,
      color = JetsnackTheme.colors.textPrimary,
      modifier = HorizontalPadding
    )

    Spacer(Modifier.height(8.dp))
    JetsnackDivider()
  }
}

@Composable
private fun Image(
  imageUrl: String,
  modifier: Modifier = Modifier,
) {
  UrlImage(
    imageUrl,
    contentDescription = null,
    modifier = modifier
      .size(ImageSize)
      .clip(CircleShape)
  )
}


@Composable
private fun CartBottomBar(modifier: Modifier = Modifier) {
  MaterialTheme.typography.h2
  MaterialTheme.typography.h3
  MaterialTheme.typography.h4
  MaterialTheme.typography.h5
  MaterialTheme.typography.h6
  MaterialTheme.typography.subtitle1
  MaterialTheme.typography.subtitle2
  MaterialTheme.typography.body1
  MaterialTheme.typography.body2
  MaterialTheme.typography.button.copy(fontWeight = FontWeight.W900)
  MaterialTheme.typography.caption
  MaterialTheme.typography.overline
  val (count, updateCount) = remember { mutableStateOf(1) }
  JetsnackSurface(modifier) {
    Column {
      JetsnackDivider()
      Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
          .navigationBarsPadding()
          .then(HorizontalPadding)
          .heightIn(min = BottomBarHeight)
      ) {
        QuantitySelector(
          count = count,
          decreaseItemCount = { if (count > 0) updateCount(count - 1) },
          increaseItemCount = { updateCount(count + 1) }
        )
        Spacer(Modifier.width(16.dp))
        JetsnackButton(
          onClick = { /* todo */ },
          modifier = Modifier.weight(1f)
        ) {
          Text(
            text = "ADD TO CART",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            maxLines = 1
          )
        }
      }
    }
  }
}

@Preview("default", device = "id:pixel_7_pro")
@Composable
private fun SnackDetailPreview() {
  JetsnackTheme {
    SnackDetailSolution(
      snack = snacks[0],
      backPress = { }
    )
  }
}
