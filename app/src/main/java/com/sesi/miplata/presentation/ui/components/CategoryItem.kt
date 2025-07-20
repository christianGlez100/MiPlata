package com.sesi.miplata.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun CategoryItem(){
    ConstraintLayout(modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
        val (cardIcon, title) = createRefs()

        ElevatedCard(modifier = Modifier.constrainAs(cardIcon) {
            top.linkTo(parent.top, 8.dp)
            start.linkTo(parent.start, margin = 16.dp)
            bottom.linkTo(parent.bottom, 8.dp)
        }) {
            Icon(
                imageVector = Icons.Filled.AccountBalance,
                contentDescription = "icon",
                modifier = Modifier
                    .size(35.dp)
                    .padding(7.dp)
            )
        }
        Text(
            text = "Renta",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary,
            maxLines = 1,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top)
                start.linkTo(cardIcon.end, margin = 16.dp)
                bottom.linkTo(parent.bottom)
            })
    }
}