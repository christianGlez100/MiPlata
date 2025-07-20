package com.sesi.miplata.presentation.ui.screen.categories.catalog

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.sesi.miplata.R
import com.sesi.miplata.presentation.ui.components.CategoryItem

@Preview
@Composable
fun CatalogCategories(){
    ConstraintLayout(modifier = Modifier.fillMaxSize().padding(top = 16.dp)) {
        val (list, titleIncome, titleExpense, expenseList, addButton) = createRefs()
        val middleLine = createGuidelineFromTop(0.5f)
        Text(text = stringResource(id = R.string.tv_ingresos),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.constrainAs(titleIncome) {
                top.linkTo(parent.top)
                start.linkTo(parent.start, margin = 8.dp)
            })
        LazyColumn(
            modifier = Modifier.constrainAs(list) {
                top.linkTo(titleIncome.bottom, margin = 8.dp)
                start.linkTo(parent.start, margin = 8.dp)
                end.linkTo(parent.end)
                bottom.linkTo(middleLine, margin = 8.dp)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
        ) {
            items(5) {
                CategoryItem()
            }
        }
        Text(text = stringResource(id = R.string.tv_gastos),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.constrainAs(titleExpense) {
                top.linkTo(middleLine, margin = 8.dp)
                start.linkTo(parent.start, margin = 8.dp)

            })
        LazyColumn(
            modifier = Modifier.constrainAs(expenseList) {
                top.linkTo(titleExpense.bottom, margin = 8.dp)
                start.linkTo(parent.start, margin = 8.dp)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom, margin = 8.dp)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }){
            items(5){
                CategoryItem()
            }
        }
        FloatingActionButton(
            onClick = {},
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.constrainAs(addButton) {
                bottom.linkTo(middleLine)
                top.linkTo(middleLine)
                end.linkTo(parent.end, margin = 16.dp)
            }
        ){
            Icon(Icons.Filled.Add, contentDescription = "Add")
        }
    }
}