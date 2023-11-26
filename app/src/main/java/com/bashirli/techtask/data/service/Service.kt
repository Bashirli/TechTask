package com.bashirli.techtask.data.service


import com.bashirli.techtask.common.utils.MockData
import com.bashirli.techtask.data.dto.card.CardDTO
import com.bashirli.techtask.data.dto.card.CardResponseDTO
import com.bashirli.techtask.data.dto.details.CategoryDetailsDTO
import kotlin.random.Random

class Service {

    val md = MockData()

    fun getCards(): List<CardDTO> = md.cardList

    fun getCardDetails(id: Int): CardResponseDTO {
        return when (id) {
            1 -> md.cardResponseDTO
            else -> md.cardResponseDTO2
        }
    }

    fun getStatisticsByDate(year: String, month: String): CardResponseDTO {
        return when (val randomNum = Random.nextInt(0, 4)) {
            1 -> md.cardResponseDTO
            2 -> md.cardResponseDTO2
            3 -> md.cardResponseDTO3
            4 -> md.cardResponseDTO4
            else -> md.cardResponseDTO2
        }
    }

    fun getDetails(id: Int): CategoryDetailsDTO = md.getCategoryDetailsDTO(id)

}