package com.nithin.expensetracker_1.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nithin.expensetracker_1.presentation.add_expense.AddExpenseScreen
import com.nithin.expensetracker_1.presentation.add_expense.viewModel.AddExpenseScreenViewModel
import com.nithin.expensetracker_1.presentation.dashboardviewmodel.DashBoardViewModel
import com.nithin.expensetracker_1.presentation.homescreen.DashBoardScreenRevamped

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination : String = Screens.HomeScreen.route
) {

    val dashBoardViewModel = viewModel<DashBoardViewModel>()
    val addExpenseViewModel = viewModel<AddExpenseScreenViewModel>()

    NavHost(
        navController = navHostController,
        startDestination = startDestination,
    ){

        composable(route = Screens.HomeScreen.route) {
            DashBoardScreenRevamped(
                modifier = modifier,
                dashBoardViewModel = dashBoardViewModel,
                navHostController = navHostController
            )
        }

        composable(route = Screens.AddExpenseScreen.route) {
            AddExpenseScreen(
                viewModel = addExpenseViewModel,
                modifier = modifier,
                navHostController = navHostController
            )
        }

    }

}