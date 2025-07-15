package com.sesi.miplata.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sesi.miplata.R
import com.sesi.miplata.presentation.ui.theme.MiPlataTypography


@Composable
fun MiPlataTopBar(title: String = "", isBackVisible:Boolean = false, onBackEvent: () -> Unit){
    Box(modifier = Modifier.background(MaterialTheme.colorScheme.primary).fillMaxWidth().height(60.dp)){
        if (isBackVisible){
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(onClick = { onBackEvent() },) {
                    Icon(
                        painter = painterResource(R.drawable.ic_left_arrow),
                        contentDescription = "back button",
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = title,
                style = MiPlataTypography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }
}