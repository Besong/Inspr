package com.besonganong.connectivity

import kotlinx.coroutines.flow.StateFlow

/**
 * Contract/Interface that defines the functionality of NetworkConnectionManager
 */
interface NetworkConnectionManager {

    /**
     * Emits Boolean when the current network becomes available or not.
     */
    val isNetworkConnectedState: StateFlow<Boolean>

    val isNetworkConnected: Boolean

    fun startListenNetworkState()

    fun stopListenNetworkState()
}