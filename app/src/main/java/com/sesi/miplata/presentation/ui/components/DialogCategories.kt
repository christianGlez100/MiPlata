package com.sesi.miplata.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun DialogCategory(isDialogVisible: Boolean){
    val openAlertDialog = remember { mutableStateOf(isDialogVisible) }

    if (openAlertDialog.value) {
        Dialog(onDismissRequest = { openAlertDialog.value = false }) {
            ConstraintLayout(
                modifier = Modifier.fillMaxWidth()
            ) {
                val (card,title, dropdown, btnOk, btnCancel) = createRefs()
                ElevatedCard(modifier = Modifier.constrainAs(card){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }) {  }
            }
        }
    }
}