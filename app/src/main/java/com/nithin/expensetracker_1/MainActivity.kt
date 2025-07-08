package com.nithin.expensetracker_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import com.nithin.expensetracker_1.presentation.components.DashBoardComponent
import com.nithin.expensetracker_1.presentation.dashboardviewmodel.DashBoardViewModel
import com.nithin.expensetracker_1.presentation.homescreen.DashBoardScreenRevamped
import com.nithin.expensetracker_1.presentation.homescreen.HomeScreen
import com.nithin.expensetracker_1.presentation.theme.ExpenseTracker1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpenseTracker1Theme {
                Scaffold {padd->
                    val dashBoardViewModel = DashBoardViewModel()
                    LaunchedEffect(Unit) {
                        dashBoardViewModel.prepareUIData()
                    }
                    DashBoardScreenRevamped(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padd),
                        dashBoardViewModel = dashBoardViewModel
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