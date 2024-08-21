package com.besonganong.listquotesfeature.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.besonganong.connectivity.NetworkConnectionManager
import com.besonganong.listquotesfeature.R
import com.besonganong.listquotesfeature.data.repository.QuotesRepository
import com.besonganong.listquotesfeature.model.QuotesScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

/**
 * ViewModel used for providing states to the QuotesScreen
 */
class QuotesViewModel (
    private val quotesRepository: QuotesRepository,
    private val networkConnectionManager: NetworkConnectionManager
): ViewModel() {

    private val _uiState = MutableStateFlow<QuotesScreenState>(QuotesScreenState.Loading)

    val uiState: StateFlow<QuotesScreenState> = _uiState

    init {
        // Begin listening to internet connectivity state in the MainActivity
        networkConnectionManager.startListenNetworkState()
        updateState()
    }

    fun onErrorButtonClick() {
        updateState()
    }

    private fun updateState() {
        viewModelScope.launch {

            networkConnectionManager.isNetworkConnectedState
                .onEach {
                    if (it) {
                        quotesRepository.getQuotes()
                            .catch {cause ->
                                cause.printStackTrace()
                                _uiState.value = QuotesScreenState.Error(R.string.cant_load_quotes)
                            }.collect {
                                    latestQuotes -> _uiState.value = QuotesScreenState.Success(latestQuotes)
                            }

                    } else {
                        _uiState.value = QuotesScreenState.Error(R.string.network_is_disconnected)
                    }

                }.collect()

        }
    }
}