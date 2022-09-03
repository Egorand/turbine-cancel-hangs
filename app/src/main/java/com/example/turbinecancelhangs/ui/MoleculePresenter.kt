package com.example.turbinecancelhangs.ui

import androidx.compose.runtime.Composable

@Composable
fun MoleculePresenter(): Model {
  return Model("Hello!")
}

data class Model(val text: String)
