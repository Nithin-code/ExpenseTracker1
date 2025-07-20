package com.nithin.expensetracker_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.nithin.expensetracker_1.navigation.NavigationHost
import com.nithin.expensetracker_1.navigation.Screens
import com.nithin.expensetracker_1.presentation.add_expense.AddExpenseScreen
import com.nithin.expensetracker_1.presentation.add_expense.viewModel.AddExpenseScreenViewModel
import com.nithin.expensetracker_1.presentation.components.DashBoardComponent
import com.nithin.expensetracker_1.presentation.dashboardviewmodel.DashBoardViewModel
import com.nithin.expensetracker_1.presentation.homescreen.DashBoardScreenRevamped
import com.nithin.expensetracker_1.presentation.homescreen.HomeScreen
import com.nithin.expensetracker_1.presentation.theme.ExpenseTracker1Theme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<AddExpenseScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpenseTracker1Theme {
                Scaffold { padd->

                    val navHostController = rememberNavController()

                    NavigationHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padd),
                        navHostController = navHostController,
                        startDestination = Screens.HomeScreen.route
                    )

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExpenseTracker1Theme {
        Greeting("Android")
    }
}