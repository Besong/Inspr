package com.besonganong.connectivity

import android.net.NetworkCapabilities

/**
 * Utility function to check CurrentNetwork is connected successfully.
 */
fun CurrentNetwork.isConnected(): Boolean {

    return isListening &&
            isAvailable &&
            !isBlocked &&
            networkCapabilities.isNetworkCapabilitiesValid()
}

/**
 * Utility function to specify the network type and network capabilities that
 * is valid for the app's requirements
 */
fun NetworkCapabilities?.isNetworkCapabilitiesValid(): Boolean = when {
    this == null -> false

    hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
            hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED) &&
            (hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    hasTransport(NetworkCapabilities.TRANSPORT_VPN) ||
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) -> true

    else -> false
}