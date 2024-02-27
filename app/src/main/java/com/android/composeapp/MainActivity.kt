package com.android.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.android.composeapp.model.snacks
import com.android.composeapp.ui.details.SnackDetail
import com.android.composeapp.ui.theme.JetsnackTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      JetsnackTheme {
        SnackDetail(snacks[0], backPress = {})
      }
    }
  }
}