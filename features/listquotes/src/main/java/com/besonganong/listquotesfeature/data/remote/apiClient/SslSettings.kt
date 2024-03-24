package com.besonganong.listquotesfeature.data.remote.apiClient

import android.content.Context
import java.security.KeyStore
import java.security.cert.Certificate
import java.security.cert.CertificateFactory
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager

object SslSettings {
    private fun getKeyStore(context: Context): KeyStore {

        val certificateFactory = CertificateFactory.getInstance("X.509")

        val keyStoreFile = context.resources.openRawResource(com.besonganong.inspr.R.raw.isrg)

        lateinit var certificate: Certificate
        keyStoreFile.use {
            certificate = certificateFactory.generateCertificate(it)
        }

        val keyStore: KeyStore = KeyStore.getInstance(KeyStore.getDefaultType())

        keyStore.load(null, null)

        keyStore.setCertificateEntry("ca", certificate)

        return keyStore
    }

    private fun getTrustManagerFactory(context: Context): TrustManagerFactory? {
        val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        trustManagerFactory.init(getKeyStore(context))
        return trustManagerFactory
    }

    fun getSslContext(context: Context): SSLContext? {
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, getTrustManagerFactory(context)?.trustManagers, null)
        return sslContext
    }

    fun getTrustManager(context: Context): X509TrustManager {
        return getTrustManagerFactory(context)?.trustManagers?.first { it is X509TrustManager } as X509TrustManager
    }
}