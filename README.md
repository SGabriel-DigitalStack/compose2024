# 🛠️ Task 1

<img src="/assets/Pasted image 20240219212612.png" width = 300px/>\
**path**: `/ui/snacks/SnackCard.kt`

## Notes

- instead of the gradient, 🎨`JetsnackTheme.colors.brand` can be used instead
- the image can be loaded using `UrlImage` from `/ui/components/UrlImage`
- the image will show the pop-corn placeholder until the app or the preview are run

# 🛠️ Task 2

<img src="/assets/Pasted image 20240219224225.png" width = 300px/>\
**path**: `/ui/details/SnackDetails.kt`

## 📚 Cheatsheet

#### Composables

[Box](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/package-summary#Box(androidx.compose.ui.Modifier))\
[Column](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/package-summary#Column(androidx.compose.ui.Modifier,androidx.compose.foundation.layout.Arrangement.Vertical,androidx.compose.ui.Alignment.Horizontal,kotlin.Function1))\
[Row](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/package-summary#Row(androidx.compose.ui.Modifier,androidx.compose.foundation.layout.Arrangement.Horizontal,androidx.compose.ui.Alignment.Vertical,kotlin.Function1))\
[Text](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#Text(kotlin.String,androidx.compose.ui.Modifier,androidx.compose.ui.graphics.Color,androidx.compose.ui.unit.TextUnit,androidx.compose.ui.text.font.FontStyle,androidx.compose.ui.text.font.FontWeight,androidx.compose.ui.text.font.FontFamily,androidx.compose.ui.unit.TextUnit,androidx.compose.ui.text.style.TextDecoration,androidx.compose.ui.text.style.TextAlign,androidx.compose.ui.unit.TextUnit,androidx.compose.ui.text.style.TextOverflow,kotlin.Boolean,kotlin.Int,kotlin.Int,kotlin.Function1,androidx.compose.ui.text.TextStyle))\
UrlImage (`/ui/components/UrlImage`)

#### Modifiers

[All modifier](https://developer.android.com/jetpack/compose/modifiers-list)\
background, size, clip, fillMaxSize/Width/Height, size,

# Fonts📏, colors🎨 and shapes📐

The referenced type styles, colors and shapes can be accessed through the `JetsnackTheme`:

```kotlin
JetsnackTheme.colors.< name > 🎨
JetsnackTheme.typography.< name > 📏
JetsnackTheme.shapes.< name > 📐
```
