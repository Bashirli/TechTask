package com.bashirli.techtask.data.dto.details

import com.bashirli.techtask.data.dto.card.CardCategory

data class CategoryDetailsDTO(
    val details: CardCategory?,
    val statements: List<Statements>?,
)
