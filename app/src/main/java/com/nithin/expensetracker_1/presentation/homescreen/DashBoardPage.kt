package com.nithin.expensetracker_1.presentation.homescreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nithin.expensetracker_1.data.TransactionDetails
import com.nithin.expensetracker_1.data.TransactionType
import com.nithin.expensetracker_1.domain.toDisplayValue
import com.nithin.expensetracker_1.presentation.dashboardviewmodel.DashBoardViewModel
import com.nithin.expensetracker_1.presentation.theme.cardPurple
import com.nithin.expensetracker_1.presentation.theme.detailsPurple
import com.nithin.expensetracker_1.presentation.theme.lightGray
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow

val items = listOf(
    TransactionDetails(
        icon = Icons.Default.ShoppingCart,
        transactionMadeAt = "Nike Store",
        transactionAmount = 1024.00,
        transactionDate = "04 July",
        transactionType = TransactionType(
            isCredit = false
        )
    ),
    TransactionDetails(
        icon = Icons.Default.ShoppingCart,
        transactionMadeAt = "Nike Store",
        transactionAmount = 1024.00,
        transactionDate = "03 July",
        transactionType = TransactionType(
            isCredit = true
        )
    ),
    TransactionDetails(
        icon = Icons.Default.ShoppingCart,
        transactionMadeAt = "Nike Store",
        transactionAmount = 1024.00,
        transactionDate = "02 July",
        transactionType = TransactionType(
            isCredit = false
        )
    ),
    TransactionDetails(
        icon = Icons.Default.ShoppingCart,
        transactionMadeAt = "Nike Store",
        transactionAmount = 1024.00,
        transactionDate = "01 July",
        transactionType = TransactionType(
            isCredit = true
        )
    ),

    TransactionDetails(
        icon = Icons.Default.ShoppingCart,
        transactionMadeAt = "Nike Store",
        transactionAmount = 1024.00,
        transactionDate = "04 July",
        transactionType = TransactionType(
            isCredit = true
        )
    ),
)

val itemsFlow = flow<List<TransactionDetails>> {
    items
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    
    LaunchedEffect(Unit) {
        val dashBoardViewModel = DashBoardViewModel()
        dashBoardViewModel.getUIData()
    }

    Column(
        modifier = modifier
            .padding(
                horizontal = 20.dp,
                vertical = 10.dp
            ),
    ) {

        HeaderTextRow()

        Spacer(modifier = Modifier
            .height(15.dp)
        )

        InfoCard()

        Spacer(modifier = Modifier
            .height(15.dp)
        )

        LazyColumn {

            item {
                Text("05 July")
            }

            items(count = items.count()){index->
                TransactionDetailsItem(
                    transactionDetails = items[index]
                )
            }
        }

    }

}

@Composable
fun InfoCard(
    modifier: Modifier = Modifier
) {

    Surface(
        modifier = modifier,
        color = cardPurple,
        shape = RoundedCornerShape(20.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.CenterStart
        ){
            CardInfoDetails(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp)
            )
        }

    }
    
}

@Composable
fun HeaderTextRow(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column {

            Text(
                text = "Hello,",
                fontSize = 28.sp
            )

            Text(
                text = "Nithin",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Surface(
            modifier = Modifier,
            shape = CircleShape,
            border = BorderStroke(
                width = 1.dp,
                color = Color.Gray
            )
        ) {
            Box(
                modifier = Modifier.size(38.dp),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "search"
                )
            }
        }

    }


}


@Preview(showBackground = true)
@Composable
fun TransactionDetailsItem(
    transactionDetails: TransactionDetails = TransactionDetails(
        icon = Icons.Default.ShoppingCart,
        transactionMadeAt = "Nike Store",
        transactionAmount = 1024.00,
        transactionDate = "04 July",
        transactionType = TransactionType(
            isCredit = false
        )
    )
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Text(
            text = transactionDetails.transactionDate,
            fontSize = 18.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Surface(
                modifier = Modifier,
                color = lightGray,
                shape = RoundedCornerShape(20.dp)
            ) {

                Box(
                    modifier = Modifier
                        .size(50.dp),
                    contentAlignment = Alignment.Center
                ){

                    Icon(
                        imageVector = transactionDetails.icon,
                        contentDescription = "",
                        tint = cardPurple
                    )

                }

            }

            Spacer(modifier = Modifier.width(25.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = transactionDetails.transactionMadeAt
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Clothing",
                    color = Color.Gray
                )
            }

            Column(modifier = Modifier) {
                Text(
                    text = transactionDetails.transactionAmount.toDisplayValue(transactionDetails.transactionType.isCredit),
                    color = transactionDetails.transactionType.indicatorColor
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Debited",
                    color = Color.Gray
                )
            }


        }
        
    }

}


@Preview(showBackground = true)
@Composable
fun CardInfoDetails(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            text = "Average Daily Spend:  ",
            color = detailsPurple
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Average Daily Gain: ",
            color = detailsPurple
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Average Monthly Spend: ",
            color = detailsPurple
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Average Monthly Income: ",
            color = detailsPurple
        )

    }

}

@Preview(showBackground = true)
@Composable
private fun Prev() {
    Scaffold {padd->

        HomeScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(padd)
        )

    }
}