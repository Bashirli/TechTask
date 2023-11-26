package com.bashirli.techtask.data.source

import com.bashirli.techtask.common.Resource
import com.bashirli.techtask.data.dto.card.CardDTO
import com.bashirli.techtask.data.dto.card.CardResponseDTO
import com.bashirli.techtask.data.dto.details.CategoryDetailsDTO
import com.bashirli.techtask.data.service.Service
import javax.inject.Inject

class ServiceSourceImpl @Inject constructor(
    private val service: Service,
) : ServiceSource {

    override fun getCards(): Resource<List<CardDTO>> = handleResult { service.getCards() }

    override fun getCardDetails(id: Int): Resource<CardResponseDTO> =
        handleResult { service.getCardDetails(id) }

    override fun getStatisticsByDate(year: String, month: String): Resource<CardResponseDTO> =
        handleResult { service.getStatisticsByDate(year, month) }

    override fun getDetails(id: Int): Resource<CategoryDetailsDTO> =
        handleResult { service.getDetails(id) }

    private fun <T> handleResult(response: () -> T): Resource<T> {
        return try {
            val data = response.invoke()
            Resource.Success(data)
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }


}