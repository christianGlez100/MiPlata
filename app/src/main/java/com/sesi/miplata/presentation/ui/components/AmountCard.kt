package com.sesi.miplata.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.sesi.miplata.R

@Preview
@Composable
fun AmountCard() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val middleGuideLine = createGuidelineFromStart(0.5f)
        val startGuideLine = createGuidelineFromStart(0.03f)
        val startNetGuideLine = createGuidelineFromStart(0.2f)
        val endGuideLine = createGuidelineFromEnd(0.03f)
        val endNetGuideLine = createGuidelineFromEnd(0.2f)
        val topGuideLine = createGuidelineFromTop(0.1f)
        val (incomeCard, expenseCard, balanceCard) = createRefs()
        ElevatedCard(Modifier
            .height(90.dp)
            .constrainAs(incomeCard) {
                top.linkTo(topGuideLine)
                start.linkTo(startGuideLine)
                end.linkTo(middleGuideLine, margin = 4.dp)
                width = androidx.constraintlayout.compose.Dimension.fillToConstraints
            }) {
            ContentAmountCard(stringResource(R.string.lbl_ingreso))
        }
        ElevatedCard(Modifier
            .height(90.dp)
            .constrainAs(expenseCard) {
                top.linkTo(topGuideLine)
                start.linkTo(middleGuideLine, margin = 4.dp)
                end.linkTo(endGuideLine)
                width = androidx.constraintlayout.compose.Dimension.fillToConstraints
            }){
            ContentAmountCard(stringResource(R.string.lbl_gastos))
        }
        ElevatedCard(Modifier
            .height(90.dp)
            .constrainAs(balanceCard) {
                top.linkTo(expenseCard.bottom, margin = 10.dp)
                start.linkTo(startNetGuideLine)
                end.linkTo(endNetGuideLine)
                width = androidx.constraintlayout.compose.Dimension.fillToConstraints
            }){
            ContentAmountCard(stringResource(R.string.tv_ingreso_neto))
        }
    }
}