package com.nithin.expensetracker_1.presentation.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.nithin.expensetracker_1.navigation.Screens
import com.nithin.expensetracker_1.presentation.components.DashBoardComponent
import com.nithin.expensetracker_1.presentation.components.PiChatCard
import com.nithin.expensetracker_1.presentation.components.TransactionDetailsListCard
import com.nithin.expensetracker_1.presentation.dashboardviewmodel.DashBoardViewModel
import com.nithin.expensetracker_1.presentation.navigation.MyBottomNavigationBar


@Composable
fun DashBoardScreenRevamped(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    dashBoardViewModel: DashBoardViewModel = DashBoardViewModel()
) {

    dashBoardViewModel.prepareUIData()

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .verticalScroll(state = scrollState, enabled = true)
            .padding(bottom = 10.dp)
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
                .fillMaxWidth()
                .weight(1f)

        ) {

            println(dashBoardViewModel.map.keys.size)

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

        Spacer(modifier = Modifier.height(15.dp))

        MyBottomNavigationBar(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        ) { itemIndex->

            if (itemIndex == 1){
                navHostController
                    .navigate(
                        Screens.AddExpenseScreen.route
                    )
            }

        }



    }

}