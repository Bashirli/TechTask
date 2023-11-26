package com.bashirli.techtask.domain.useCase

import com.bashirli.techtask.data.repository.ServiceRepository
import javax.inject.Inject

class ServiceUseCase @Inject constructor(
    private val repo: ServiceRepository,
) {

    fun getCards() = repo.getCards()

    fun getCardDetails(id: Int) = repo.getCardDetails(id)


    fun getStatisticsByDate(year: String, month: String) = repo.getStatisticsByDate(year, month)

    fun getDetails(id: Int) = repo.getDetails(id)

}