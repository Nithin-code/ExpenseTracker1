package com.nithin.expensetracker_1.presentation.navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    onMenuItemClick : () -> Unit,
) {
    val localConfiguration = LocalConfiguration.current
    val screenWidthDP = localConfiguration.screenWidthDp

    Row(
        modifier = modifier,

    ) {



    }


}

@Preview
@Composable
private fun Preview() {
    BottomNavigationBar(
        onMenuItemClick = {

        }
    )
}