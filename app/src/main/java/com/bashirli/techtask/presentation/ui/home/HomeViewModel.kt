package com.bashirli.techtask.presentation.ui.home

import com.bashirli.techtask.common.base.BaseViewModel
import com.bashirli.techtask.common.base.Effect
import com.bashirli.techtask.common.base.State
import com.bashirli.techtask.domain.model.CardResponseUiModel
import com.bashirli.techtask.domain.model.CardUiModel
import com.bashirli.techtask.domain.model.CategoryDetailsUiModel
import com.bashirli.techtask.domain.useCase.ServiceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: ServiceUseCase,
) : BaseViewModel<HomeUiState, HomeUiEffect>() {


    init {
        getCards()
    }

    fun getCards() {
        useCase.getCards().handleResult(
            onComplete = {
                setState(HomeUiState.Cards(it))
            },
            onError = {
                setState(HomeUiState.Error)
                setEffect(HomeUiEffect.ShowMessage(it.localizedMessage as String))
            }
        )
    }

    fun getCardDetails(id: Int) {
        useCase.getCardDetails(id).handleResult(
            onComplete = {
                setState(HomeUiState.CardDetails(it))
            },
            onError = {
                setState(HomeUiState.Error)
                setEffect(HomeUiEffect.ShowMessage(it.localizedMessage as String))
            }
        )
    }

    fun getStatistics(year: String, month: String) {
        useCase.getStatisticsByDate(year, month).handleResult(
            onComplete = {
                setState(HomeUiState.CardDetails(it))
            },
            onError = {
                setState(HomeUiState.Error)
                setEffect(HomeUiEffect.ShowMessage(it.localizedMessage as String))
            }
        )
    }

    fun getDetails(id: Int) {
        useCase.getDetails(id).handleResult(
            onComplete = {
                setState(HomeUiState.CategoryDetails(it))
            },
            onError = {
                setState(HomeUiState.Error)
                setEffect(HomeUiEffect.ShowMessage(it.localizedMessage as String))
            }
        )
    }


}

sealed interface HomeUiState : State {

    data object Error : HomeUiState

    data class Cards(val data: List<CardUiModel>) : HomeUiState

    data class CardDetails(val data: CardResponseUiModel) : HomeUiState

    data class CategoryDetails(val data: CategoryDetailsUiModel) : HomeUiState

}

sealed interface HomeUiEffect : Effect {
    data class ShowMessage(val message: String?) : HomeUiEffect
}