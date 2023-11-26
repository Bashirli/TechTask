package com.bashirli.techtask.data.mapper

import com.bashirli.techtask.data.dto.card.CardCategory
import com.bashirli.techtask.data.dto.card.CardDTO
import com.bashirli.techtask.data.dto.card.CardResponseDTO
import com.bashirli.techtask.data.dto.card.UserStatistics
import com.bashirli.techtask.data.dto.details.CategoryDetailsDTO
import com.bashirli.techtask.data.dto.details.Statements
import com.bashirli.techtask.domain.model.CardCategoryUiModel
import com.bashirli.techtask.domain.model.CardResponseUiModel
import com.bashirli.techtask.domain.model.CardUiModel
import com.bashirli.techtask.domain.model.CategoryDetailsUiModel
import com.bashirli.techtask.domain.model.StatementsUiModel
import com.bashirli.techtask.domain.model.UserStatisticsUiModel

fun List<Statements>.toStatementsUiModel() =
    map { with(it) { StatementsUiModel(id, icon, title, date, price) } }

fun List<CardDTO>.toCardUiModel() =
    map { with(it) { CardUiModel(id, name, number, image, isSelected) } }

fun List<CardCategory>.toCardCategoryUiModel() =
    map { with(it) { CardCategoryUiModel(id, name, icon, color, percentage, price) } }

fun UserStatistics.toUserStatisticsUiModel() = UserStatisticsUiModel(expenses, incomings, cashback)

fun CardResponseDTO.toCardResponseUiModel() = CardResponseUiModel(
    userStatistics?.toUserStatisticsUiModel(),
    categories?.toCardCategoryUiModel()
)

fun CardCategory.toCardCategoryUiModel() =
    CardCategoryUiModel(id, name, icon, color, percentage, price)

fun CategoryDetailsDTO.toCategoryDetailsUiModel() = CategoryDetailsUiModel(
    details?.toCardCategoryUiModel(),
    statements?.toStatementsUiModel()
)

