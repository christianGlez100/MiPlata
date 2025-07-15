package com.sesi.miplata.presentation.ui.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sesi.miplata.presentation.ui.components.MiPlataTopBar

@Preview
@Composable
fun PreviewTopBar(){
    MiPlataTopBar(title = "Home", isBackVisible = true, onBackEvent = {})
}