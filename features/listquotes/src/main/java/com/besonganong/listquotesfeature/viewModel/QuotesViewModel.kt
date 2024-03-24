package com.besonganong.listquotesfeature.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.besonganong.listquotesfeature.data.repository.QuotesRepository
import com.besonganong.listquotesfeature.model.QuotesScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

/**
 * ViewModel used for providing states to the QuotesScreen
 */
class QuotesViewModel (
    private val quotesRepository: QuotesRepository
): ViewModel() {

    private val _uiState = MutableStateFlow<QuotesScreenState>(QuotesScreenState.Loading)

    val uiState: StateFlow<QuotesScreenState> = _uiState


    init {
        updateState()
    }

    fun onErrorButtonClick() {
        updateState()
    }

    private fun updateState() {
        viewModelScope.launch {

            quotesRepository.getQuotes()
                .catch {cause ->
                    cause.message?.let {
                      //  Log.e(this@QuotesViewModel.toString(), it)
                    }

                    _uiState.value = QuotesScreenState.Error
                }
                .collect { latestQuotes ->
                    _uiState.value = QuotesScreenState.Success(latestQuotes)
                }
        }
    }
}