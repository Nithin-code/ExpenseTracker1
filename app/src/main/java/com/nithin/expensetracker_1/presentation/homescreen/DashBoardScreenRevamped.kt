package com.nithin.expensetracker_1.presentation.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nithin.expensetracker_1.presentation.components.DashBoardComponent
import com.nithin.expensetracker_1.presentation.components.PiChatCard
import com.nithin.expensetracker_1.presentation.components.TransactionDetailsListCard
import com.nithin.expensetracker_1.presentation.dashboardviewmodel.DashBoardViewModel

@Preview(showBackground = true)
@Composable
fun DashBoardScreenRevamped(
    modifier: Modifier = Modifier,
    dashBoardViewModel: DashBoardViewModel = DashBoardViewModel()
) {

    Column(
        modifier = modifier
    ) {

        HeaderTextRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        DashBoardComponent(
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        PiChatCard(
            modifier = Modifier.fillMaxWidth()
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {

            dashBoardViewModel.map.keys.forEach { key->

                item {
                    dashBoardViewModel.map[key]?.let {
                        TransactionDetailsListCard(
                            date = key,
                            itemsList = it
                        )
                    }
                }

            }

        }

    }

}