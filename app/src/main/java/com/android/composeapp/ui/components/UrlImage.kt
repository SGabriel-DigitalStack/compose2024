package com.android.composeapp.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.android.composeapp.R

@Composable
fun UrlImage(
  url: String,
  contentDescription: String?,
  modifier: Modifier = Modifier,
) {
  AsyncImage(
    model = ImageRequest.Builder(LocalContext.current)
      .data(url)
      .crossfade(true)
      .build(),
    contentDescription = contentDescription,
    placeholder = painterResource(R.drawable.placeholder),
    modifier = modifier.fillMaxSize(),
    contentScale = ContentScale.Crop,
  )
}