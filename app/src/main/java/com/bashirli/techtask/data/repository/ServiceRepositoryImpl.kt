package com.bashirli.techtask.data.repository

import com.bashirli.techtask.common.Resource
import com.bashirli.techtask.data.mapper.toCardResponseUiModel
import com.bashirli.techtask.data.mapper.toCardUiModel
import com.bashirli.techtask.data.mapper.toCategoryDetailsUiModel
import com.bashirli.techtask.data.source.ServiceSource
import com.bashirli.techtask.domain.model.CardResponseUiModel
import com.bashirli.techtask.domain.model.CardUiModel
import com.bashirli.techtask.domain.model.CategoryDetailsUiModel
import javax.inject.Inject


class ServiceRepositoryImpl @Inject constructor(
    private val source: ServiceSource,
) : ServiceRepository {
    override fun getCards(): Resource<List<CardUiModel>> {
        return when (val response = source.getCards()) {
            is Resource.Error -> Resource.Error(response.throwable)
            is Resource.Success -> Resource.Success(response.result?.toCardUiModel())
        }
    }

    override fun getCardDetails(id: Int): Resource<CardResponseUiModel> {
        return when (val response = source.getCardDetails(id)) {
            is Resource.Error -> Resource.Error(response.throwable)
            is Resource.Success -> Resource.Success(response.result?.toCardResponseUiModel())
        }
    }

    override fun getStatisticsByDate(year: String, month: String): Resource<CardResponseUiModel> {
        return when (val response = source.getStatisticsByDate(year, month)) {
            is Resource.Error -> Resource.Error(response.throwable)
            is Resource.Success -> Resource.Success(response.result?.toCardResponseUiModel())
        }
    }

    override fun getDetails(id: Int): Resource<CategoryDetailsUiModel> {
        return when (val response = source.getDetails(id)) {
            is Resource.Error -> Resource.Error(response.throwable)
            is Resource.Success -> Resource.Success(response.result?.toCategoryDetailsUiModel())
        }
    }


}