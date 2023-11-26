package com.bashirli.techtask.data.source

import com.bashirli.techtask.common.Resource
import com.bashirli.techtask.data.dto.card.CardDTO
import com.bashirli.techtask.data.dto.card.CardResponseDTO
import com.bashirli.techtask.data.dto.details.CategoryDetailsDTO


interface ServiceSource {

    fun getCards(): Resource<List<CardDTO>>

    fun getCardDetails(id: Int): Resource<CardResponseDTO>


    fun getStatisticsByDate(year: String, month: String): Resource<CardResponseDTO>

    fun getDetails(id: Int): Resource<CategoryDetailsDTO>

}