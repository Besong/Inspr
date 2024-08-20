package com.besonganong.connectivity

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class NetworkConnectionManagerImpl(
    context: Context,
    coroutineScope: CoroutineScope
) : NetworkConnectionManager {

    private val connectivityManager: ConnectivityManager = context.getSystemService(ConnectivityManager::class.java)!!

    private val networkRequest = NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .addCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .addTransportType(NetworkCapabilities.TRANSPORT_VPN)
        .addTransportType(NetworkCapabilities.TRANSPORT_ETHERNET)
        .build()

    private val networkCallback = NetworkCallback()

    private val _currentNetwork = MutableStateFlow(provideDefaultCurrentNetwork())


    override val isNetworkConnectedState: StateFlow<Boolean> =
        _currentNetwork
            .map { it.isConnected() }
            .stateIn(
                scope = coroutineScope,
                started = SharingStarted.WhileSubscribed(),
                initialValue = _currentNetwork.value.isConnected()
            )



    override val isNetworkConnected: Boolean
        get() = isNetworkConnectedState.value


    override fun stopListenNetworkState() {
        if (!_currentNetwork.value.isListening) {
            return
        }

        // Reset state before stop listening
        _currentNetwork.update {
            it.copy(isListening = false)
        }

        connectivityManager.unregisterNetworkCallback(networkCallback)
    }


    override fun startListenNetworkState() {
        if (_currentNetwork.value.isListening)
            return

        // Reset state before start listening
        _currentNetwork.update {
            provideDefaultCurrentNetwork()
                .copy(isListening = true)
        }

        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)

    }

    
    /**
     * On Android 9, [ConnectivityManager.NetworkCallback.onBlockedStatusChanged] is not called when
     * we call the [ConnectivityManager.registerDefaultNetworkCallback] function.
     * Hence we assume that the network is unblocked by default.
     */

    private inner class NetworkCallback: ConnectivityManager.NetworkCallback() {

        // network is available for use
        override fun onAvailable(network: Network) {
            _currentNetwork.update {
                it.copy(isAvailable = true)
            }
        }

        // lost network connection
        override fun onLost(network: Network) {
            _currentNetwork.update {
                it.copy(isAvailable = false,
                    networkCapabilities = null)
            }
        }

        // network is unavailable to use
        override fun onUnavailable() {
            _currentNetwork.update {
                it.copy(
                    isAvailable = false,
                    networkCapabilities = null
                )
            }
        }

        // network capabilities have changed for the network
        override fun onCapabilitiesChanged(
            network: Network,
            networkCapabilities: NetworkCapabilities
        ) {
            _currentNetwork.update {
                it.copy(
                    networkCapabilities = networkCapabilities
                )
            }
        }

        // network is blocked for this AndroidOS version
        override fun onBlockedStatusChanged(network: Network, blocked: Boolean) {
            _currentNetwork.update {
                it.copy(
                    isBlocked = blocked
                )
            }
        }

    }
    private fun provideDefaultCurrentNetwork(): CurrentNetwork {

        return CurrentNetwork(
            isListening = false,
            isAvailable = false,
            networkCapabilities = null,
            isBlocked = false
        )
    }

}