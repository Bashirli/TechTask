package com.bashirli.techtask.domain.model


data class CardResponseUiModel(
    val userStatistics: UserStatisticsUiModel?,
    val categories: List<CardCategoryUiModel>?,
)
