package com.android.composeapp.common

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum

fun generateLoremIpsum(count: Int): String {
  return LoremIpsum(count).values.joinToString(separator = " ")
}

private val INGREDIENTS = listOf(
  "Sugar",
  "Flour",
  "Eggs",
  "Butter",
  "Vanilla Extract",
  "Baking Powder",
  "Baking Soda",
  "Salt",
  "Cocoa Powder",
  "Chocolate Chips",
  "Almonds",
  "Walnuts",
  "Milk",
  "Cream",
  "Yogurt",
  "Strawberries",
  "Blueberries",
  "Apples",
  "Bananas",
  "Cinnamon",
  "Nutmeg",
  "Ginger",
  "Powdered Sugar",
  "Honey",
  "Whipped Cream",
  "Almond Extract",
  "Mint Extract"
)

fun generateIngredients(count: Int): String {
  return INGREDIENTS.take(count).joinToString(separator = ",")
}