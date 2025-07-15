package com.sesi.miplata.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun OperationList() {
    ConstraintLayout(modifier = Modifier.fillMaxSize().padding(top = 16.dp)) {
        val (list, title) = createRefs()
        Text(text = "Transacciones",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.constrainAs(title) {
            top.linkTo(parent.top)
            start.linkTo(parent.start, margin = 8.dp)
        })
        LazyColumn(
            modifier = Modifier.constrainAs(list) {
                top.linkTo(title.bottom, margin = 8.dp)
                start.linkTo(parent.start, margin = 8.dp)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom, margin = 8.dp)
                width = androidx.constraintlayout.compose.Dimension.fillToConstraints
                height = androidx.constraintlayout.compose.Dimension.fillToConstraints
            }
        ) {
            items(15) {
                OperationItem()
            }
        }
    }
}