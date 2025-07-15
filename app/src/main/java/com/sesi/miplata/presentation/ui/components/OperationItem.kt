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

@Preview()
@Composable
fun OperationItem() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth().padding(top = 10.dp)) {
        val (cardIcon, title, description, type, amount) = createRefs()

        ElevatedCard(modifier = Modifier.constrainAs(cardIcon) {
            top.linkTo(parent.top)
            start.linkTo(parent.start, margin = 8.dp)
            bottom.linkTo(parent.bottom)
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
            text = "Comida Pizza",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary,
            maxLines = 1,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top)
                start.linkTo(cardIcon.end, margin = 16.dp)
                end.linkTo(amount.start, margin = 8.dp)
                width = androidx.constraintlayout.compose.Dimension.fillToConstraints
            })
        Text(
            text = "3 Pizzas de little cesars",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.secondary,
            maxLines = 1,
            modifier = Modifier.constrainAs(description) {
                top.linkTo(title.bottom)
                start.linkTo(title.start)
                end.linkTo(title.end)
                width = androidx.constraintlayout.compose.Dimension.fillToConstraints
            })
        Text(
            text = "Comida",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.tertiary,
            maxLines = 1,
            modifier = Modifier.constrainAs(type) {
                top.linkTo(description.bottom)
                start.linkTo(title.start)
                end.linkTo(title.end)
                width = androidx.constraintlayout.compose.Dimension.fillToConstraints
            })
        Text(
            text = "$ 500.00",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.error,
            maxLines = 1,
            modifier = Modifier.constrainAs(amount) {
                top.linkTo(parent.top)
                end.linkTo(parent.end, margin = 8.dp)
                bottom.linkTo(parent.bottom)
            })
    }
}