package com.bashirli.techtask.common.utils

import com.bashirli.techtask.R
import com.bashirli.techtask.data.dto.card.CardCategory
import com.bashirli.techtask.data.dto.card.CardDTO
import com.bashirli.techtask.data.dto.card.CardResponseDTO
import com.bashirli.techtask.data.dto.card.UserStatistics
import com.bashirli.techtask.data.dto.details.CategoryDetailsDTO
import com.bashirli.techtask.data.dto.details.Statements
import kotlin.random.Random


class MockData {
    // Card ->
    val card1 = CardDTO(1, "Expresso MC", "** 4554", R.drawable.card_photo, true)
    val card2 = CardDTO(2, "Expresso 2", "** 8553", R.drawable.card_photo, false)

    val cardList = listOf(card1, card2)

    // Card Response ->
    val userStatistics1 = UserStatistics(300000.0, 1700000.0, 100500.0)
    val userStatistics2 = UserStatistics(500000.0, 200000.0, 500.0)
    val userStatistics3 = UserStatistics(200000.0, 700000.0, 10500.0)
    val userStatistics4 = UserStatistics(800000.0, 1100000.0, 900.0)

    val cardCategory1 = CardCategory(1, "Airlines", R.drawable.plane_icon, "#4BAFF8", 26, 1500.0)
    val cardCategory2 =
        CardCategory(2, "Rent a car", R.drawable.rent_car_icon, "#9B2FF5", 26, 1300.0)
    val cardCategory3 =
        CardCategory(3, "Hotels and motels", R.drawable.hotel_icon, "#5723E1", 26, 1100.0)
    val cardCategory4 =
        CardCategory(4, "Transport", R.drawable.transport_icon, "#C3291C", 46, 1200.0)
    val cardCategory5 =
        CardCategory(5, "Cars and vehicles", R.drawable.car_icon, "#3255F4", 26, 2500.0)
    val cardCategory6 =
        CardCategory(6, "Government services", R.drawable.gov_services_icon, "#9D8980", 76, 5500.0)
    val cardCategory7 =
        CardCategory(
            7,
            "Personal services",
            R.drawable.personal_service_icon,
            "#50B5D0",
            26,
            1400.0
        )
    val cardCategory8 = CardCategory(
        8, "Professional services", R.drawable.proffesional_services_icon, "#757575", 26, 3200.0
    )
    val cardCategory9 =
        CardCategory(9, "Business services", R.drawable.business_icon, "#000000", 26, 1500.0)
    val cardCategory10 =
        CardCategory(10, "Repair services", R.drawable.repair_icon, "#55BCA6", 26, 1500.0)
    val cardCategory11 =
        CardCategory(11, "Clothing store", R.drawable.clothing_store_icon, "#E1325A", 26, 1600.0)
    val cardCategory12 =
        CardCategory(12, "Sale by mail or telephone", R.drawable.phone_icon, "#4BAFF8", 26, 1770.0)
    val cardCategory13 =
        CardCategory(13, "Entertainment", R.drawable.entertainment_icon, "#4BAFF8", 26, 1550.0)
    val cardCategory14 = CardCategory(
        14, "Wholesale suppliers and manufacturers", R.drawable.cashout_icon, "#4A352F", 26, 1520.0
    )
    val cardCategory15 = CardCategory(
        15, "Membership organizations", R.drawable.baseline_person_pin_24, "#B0B347", 26, 1100.0
    )
    val cardCategory16 = CardCategory(16, "Cashout", R.drawable.cashout_icon, "#5AC461", 26, 1500.0)
    val cardCategory17 =
        CardCategory(17, "Money transfers", R.drawable.money_transfer_icon, "#F9C20A", 26, 500.0)
    val cardCategory18 = CardCategory(18, "Others", R.drawable.other_icon, "#F58220", 26, 9500.0)
    val cardCategory19 =
        CardCategory(
            19,
            "Contract services",
            R.drawable.baseline_person_pin_24,
            "#B9ABA5",
            26,
            1500.0
        )
    val cardCategory20 =
        CardCategory(20, "Other services", R.drawable.settings_icon, "#5E6DBA", 26, 1500.0)
    val cardCategory21 = CardCategory(21, "Retail", R.drawable.repair_icon, "#ACDB30", 26, 1500.0)
    val cardCategory22 = CardCategory(22, "Health", R.drawable.health_icon, "#FF001F", 26, 1500.0)


    val cardCategoryList1 = listOf(
        cardCategory1,
        cardCategory2,
        cardCategory3,
        cardCategory4,
        cardCategory5,
        cardCategory6,
        cardCategory7,
        cardCategory8,
        cardCategory9,
        cardCategory10,
        cardCategory11,
        cardCategory12,
        cardCategory13,
        cardCategory14,
        cardCategory15,
        cardCategory16,
        cardCategory17,
        cardCategory18,
        cardCategory19,
        cardCategory20,
        cardCategory21,
        cardCategory22
    )
    val cardCategoryList2 = listOf(
        cardCategory1.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory2,
        cardCategory3.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory4,
        cardCategory5,
        cardCategory6.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory7,
        cardCategory8.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory9,
        cardCategory10.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory11,
        cardCategory12.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory13,
        cardCategory14,
        cardCategory15,
        cardCategory16,
        cardCategory17,
        cardCategory18.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory19,
        cardCategory20,
        cardCategory21,
        cardCategory22
    )
    val cardCategoryList3 = listOf(
        cardCategory1,
        cardCategory2.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory3,
        cardCategory4.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory5.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory6,
        cardCategory7.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory8,
        cardCategory9,
        cardCategory10,
        cardCategory11,
        cardCategory12.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory13,
        cardCategory14,
        cardCategory15,
        cardCategory16.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory17,
        cardCategory18,
        cardCategory19,
        cardCategory20.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory21,
        cardCategory22
    )
    val cardCategoryList4 = listOf(
        cardCategory1.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory2,
        cardCategory3,
        cardCategory4.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory5,
        cardCategory6,
        cardCategory7,
        cardCategory8,
        cardCategory9.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory10,
        cardCategory11,
        cardCategory12,
        cardCategory13.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory14,
        cardCategory15,
        cardCategory16.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory17,
        cardCategory18.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        ),
        cardCategory19,
        cardCategory20,
        cardCategory21,
        cardCategory22.copy(
            percentage = Random.nextInt(0, 100),
            price = Random.nextInt(0, 10000).toDouble()
        )
    )


    val cardResponseDTO = CardResponseDTO(userStatistics1, cardCategoryList1)
    val cardResponseDTO2 = CardResponseDTO(userStatistics2, cardCategoryList2)
    val cardResponseDTO3 = CardResponseDTO(userStatistics3, cardCategoryList3)
    val cardResponseDTO4 = CardResponseDTO(userStatistics4, cardCategoryList4)


    //CardDetails->
    fun getStatementsList(): List<Statements> {
        val list = arrayListOf<Statements>()
        for (i in 0..10) {
            with(cardCategoryList1[i]) {
                list.add(
                    Statements(
                        date = "13:02  17.09.2018",
                        id = i,
                        icon = if (i % 3 == 0) R.drawable.uber_photo else icon,
                        title = "Uber trip 20 UAW",
                        price = Random.nextInt(1, 100).toDouble()
                    )
                )
            }
        }
        return list
    }

    fun getCategoryDetailsDTO(id: Int): CategoryDetailsDTO =
        CategoryDetailsDTO(cardCategoryList1.first { it.id == id }, getStatementsList())


}


