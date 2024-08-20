package com.besonganong.connectivity

import android.net.NetworkCapabilities

/**
 * Model class representing currently connected network
 */

data class CurrentNetwork(
    val isListening: Boolean,
    val isAvailable: Boolean,
    val networkCapabilities: NetworkCapabilities?,
    val isBlocked: Boolean
)
