package com.nithin.expensetracker_1.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nithin.expensetracker_1.presentation.theme.cardBackground

@Composable
fun WheelDatePicker(
    modifier: Modifier = Modifier
) {



}


@Composable
fun WheelCategoryPicker(
    modifier: Modifier = Modifier
) {
    
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Select a category",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Done",
                    color = cardBackground,
                    fontSize = 16.sp,
                )

            }

            Spacer(modifier = Modifier.height(10.dp))

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.height(10.dp))

        }

    }

}

@Preview
@Composable
private fun PreviewWheelPicker() {

    Scaffold() { padd->
        WheelCategoryPicker(modifier = Modifier
            .fillMaxWidth()
            .padding(padd))
    }

}