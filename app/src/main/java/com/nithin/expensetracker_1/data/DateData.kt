package com.nithin.expensetracker_1.data

object DateData {

    val days = mutableListOf<Int>()

    fun createData(){
        for (i in 1..31)
            days.add(i)

        for (i in 1990..2050)
            years.add(i)
    }

    val months = listOf(
        "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"
    )

    val years = mutableListOf<Int>()

}