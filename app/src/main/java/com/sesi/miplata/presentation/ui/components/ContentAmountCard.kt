package com.sesi.miplata.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Payments
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
fun ContentAmountCard(operationName: String = "Income", amount: String = "$1,000,000.00") {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.primary)) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val startGuideLine = createGuidelineFromStart(0.1f)
            val endGuideLine = createGuidelineFromEnd(0.1f)
            val topGuideLine = createGuidelineFromTop(0.1f)
            val bottomGuideLine = createGuidelineFromBottom(0.1f)
            val middleGuideLineHorizontal = createGuidelineFromTop(0.5f)
            val (incomeText, incomeAmount, incomeIcon) = createRefs()
            Icon(imageVector = Icons.Filled.Payments, contentDescription = "", modifier = Modifier
                .size(35.dp)
                .constrainAs(incomeIcon) {
                    top.linkTo(topGuideLine)
                    bottom.linkTo(bottomGuideLine)
                    start.linkTo(startGuideLine)
                }, tint = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = operationName,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.constrainAs(incomeText) {

                    start.linkTo(incomeIcon.end, margin = 8.dp)
                    end.linkTo(endGuideLine)
                    bottom.linkTo(middleGuideLineHorizontal)
                })
            Text(text = amount,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.constrainAs(incomeAmount) {
                    top.linkTo(middleGuideLineHorizontal)
                    start.linkTo(incomeText.start)
                    end.linkTo(incomeText.end)
                })
        }
    }
}