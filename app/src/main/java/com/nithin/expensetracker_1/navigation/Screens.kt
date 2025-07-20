package com.nithin.expensetracker_1.navigation

sealed class Screens(val route : String){

    data object HomeScreen : Screens("Dashboard")

    data object AddExpenseScreen : Screens("AddExpense")

}