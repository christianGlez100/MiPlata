package com.sesi.miplata.presentation.ui.screen.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import com.sesi.miplata.presentation.ui.navigation.Routes

@Preview(name = "Light Mode", showBackground = true, showSystemUi = true)
@Composable
fun SettingsScreen(rootNavController: NavHostController) {
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .padding(top = 16.dp)) {
        val (categories) = createRefs()
        Text(
            text = "Categories",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.constrainAs(categories) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }.clickable {
                rootNavController.navigate(Routes.Categories.route)
            })
    }
}