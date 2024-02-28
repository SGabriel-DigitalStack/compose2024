@file:OptIn(ExperimentalFoundationApi::class)

package com.android.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.composeapp.model.Snack
import com.android.composeapp.model.snacks
import com.android.composeapp.ui.components.UrlImage
import com.android.composeapp.ui.theme.JetsnackTheme
import com.android.composeapp.ui.util.formatPrice
import com.android.composeapp.ui.util.getRandomSnack
import kotlin.random.Random

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      JetsnackTheme {
        ListExample()
      }
    }
  }
}


@Preview
@Composable
fun ListExample() {
  JetsnackTheme {
    val snacks = remember { mutableStateListOf(snacks[0], snacks[1]) }
    Column(
      modifier = Modifier.background(Color.White)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column(
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          SnackButton("+ Start") {
            snacks.add(0, getRandomSnack())
          }
          SnackButton("- Start") {
            snacks.removeFirst()
          }
        }
        Column(
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          SnackButton("+ End") {
            snacks.add(getRandomSnack())
          }
          SnackButton("- End") {
            snacks.removeLast()
          }
        }
        SnackButton("+ Middle") {
          snacks.add(Random.nextInt(1, snacks.lastIndex - 1), getRandomSnack())
        }
      }
      SnackList(snacks = snacks)
    }
  }
}


@Composable
fun SnackList(
  snacks: List<Snack>,
  modifier: Modifier = Modifier,
  state: LazyListState = rememberLazyListState(),
) {
  LazyColumn(
    state = state,
    modifier = modifier
      .fillMaxSize()
      .background(Color.White),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    itemsIndexed(snacks) { index, snack ->
      SnackListItem(
        snack,
      )

      if (index != snacks.lastIndex) {
        Divider()
      }
    }
  }
}

@Composable
private fun SnackListItem(
  snack: Snack,
  modifier: Modifier = Modifier
) {
  Row(
    modifier = modifier
      .background(Color.White)
      .fillMaxWidth()
      .padding(vertical = 16.dp, horizontal = 24.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    UrlImage(
      snack.imageUrl,
      contentDescription = null,
      Modifier
        .size(80.dp)
        .clip(CircleShape)
    )

    Spacer(Modifier.width(8.dp))

    Column(
      modifier = Modifier.weight(1f)
    ) {
      Text(
        snack.name,
        style = JetsnackTheme.typography.h5
      )
      Text(
        snack.tagline,
        style = JetsnackTheme.typography.subtitle2
      )
    }

    Spacer(Modifier.width(16.dp))

    Text(
      remember { formatPrice(snack.price) },
      style = JetsnackTheme.typography.h5,
      color = JetsnackTheme.colors.brand
    )

  }
}

@Composable
private fun SnackButton(
  text: String,
  modifier: Modifier = Modifier,
  onClick: () -> Unit,
) {
  Button(
    onClick = onClick,
    modifier = modifier,
    colors = ButtonDefaults.buttonColors(
      backgroundColor = JetsnackTheme.colors.brand,
      contentColor = Color.White,
    )
  ) {
    Text(text, style = JetsnackTheme.typography.button)
  }
}