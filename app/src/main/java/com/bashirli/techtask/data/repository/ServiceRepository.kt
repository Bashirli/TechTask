package com.bashirli.techtask.data.repository

import com.bashirli.techtask.common.Resource
import com.bashirli.techtask.domain.model.CardResponseUiModel
import com.bashirli.techtask.domain.model.CardUiModel
import com.bashirli.techtask.domain.model.CategoryDetailsUiModel

interface ServiceRepository {

    fun getCards(): Resource<List<CardUiModel>>

    fun getCardDetails(id: Int): Resource<CardResponseUiModel>


    fun getStatisticsByDate(year: String, month: String): Resource<CardResponseUiModel>

    fun getDetails(id: Int): Resource<CategoryDetailsUiModel>

}