# 🛠️ Task 

<img src="https://github.com/SGabriel-DigitalStack/compose2024/assets/160568109/13fe7533-21c1-46c0-b969-99bf859b77b4"/>

**path**: `/ui/cart/CartScreen.kt`

**TODO**
- ✏️ add state to the screen to track
  -  quantity of each item
  -  tips
- ✏️ add tips slider (use `TipsSlider` Composable)
  - add tips text row
- 🐞 fix the item count bug
  
![order_screen_bug](https://github.com/SGabriel-DigitalStack/compose2024/assets/160568109/6b674ae3-22af-4c1e-80ca-659ea99cf3e3)

## 🌟Bonus task
Add a button that adds a random snack to the cart\
A snack repository can be found in the `snacks` top level list `/model/Snack.kt`

# 📚 Cheatsheet
See `Snack` data class (`/model/Snack.kt`)

```kotlin
val counter = remember { mutableStateOf(0) }

Button(onClick = { counter.value++ }) {
  Text("Increment")
}
```

```kotlin
TipsSlider(
  tipsPercent = currentValue,
  onValueChange = { newValue -> ... }
)
```

#### Composables

[Box](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/package-summary#Box(androidx.compose.ui.Modifier))\
[Column](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/package-summary#Column(androidx.compose.ui.Modifier,androidx.compose.foundation.layout.Arrangement.Vertical,androidx.compose.ui.Alignment.Horizontal,kotlin.Function1))\
[Row](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/package-summary#Row(androidx.compose.ui.Modifier,androidx.compose.foundation.layout.Arrangement.Horizontal,androidx.compose.ui.Alignment.Vertical,kotlin.Function1))\
[Text](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#Text(kotlin.String,androidx.compose.ui.Modifier,androidx.compose.ui.graphics.Color,androidx.compose.ui.unit.TextUnit,androidx.compose.ui.text.font.FontStyle,androidx.compose.ui.text.font.FontWeight,androidx.compose.ui.text.font.FontFamily,androidx.compose.ui.unit.TextUnit,androidx.compose.ui.text.style.TextDecoration,androidx.compose.ui.text.style.TextAlign,androidx.compose.ui.unit.TextUnit,androidx.compose.ui.text.style.TextOverflow,kotlin.Boolean,kotlin.Int,kotlin.Int,kotlin.Function1,androidx.compose.ui.text.TextStyle))

#### Modifiers

[All modifier](https://developer.android.com/jetpack/compose/modifiers-list)
