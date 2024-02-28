package com.besonganong.listquotesfeature.di

import com.besonganong.NavGraphBuilderFactory
import com.besonganong.listquotesfeature.QuotesScreenNavComposableImpl
import com.besonganong.listquotesfeature.data.remote.apiClient.httpClient
import com.besonganong.listquotesfeature.data.remote.datasource.QuotesRemoteDataSource
import com.besonganong.listquotesfeature.data.remote.mapper.ClientMapper
import com.besonganong.listquotesfeature.data.remote.mapper.ClientMapperImpl
import com.besonganong.listquotesfeature.data.repository.QuotesRepository
import com.besonganong.listquotesfeature.data.repository.QuotesRepositoryImpl
import com.besonganong.listquotesfeature.viewModel.QuotesViewModel
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.android.AndroidEngineConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// QuotesRespositoryImpl -> QDs( client, delayInterval), clientMapper, coroutineScope


val quotesModules = module {

    /** Network Module **/
    single {
        HttpClientEngineConfig()
    }

    single {
        HttpClientConfig<AndroidEngineConfig>()
    }

    single{
        httpClient(get())
    }

    /** Remote DataSource Module **/

    single {
        QuotesRemoteDataSource(client = get())
    }

    /** Mapper Module **/
    single<ClientMapper> {

        ClientMapperImpl()
    }

    /** Repository Module **/

    single<QuotesRepository> {

        QuotesRepositoryImpl(
            quotesRemoteDataSource = get(),
            clientMapper = get(),
            externalScope = CoroutineScope(Dispatchers.IO)
        )
    }

    // ViewModel Module
    viewModel {
        QuotesViewModel(
            quotesRepository = get())
    }

    // QuotesScreenNavComposableImpl Module
    single<NavGraphBuilderFactory.QuotesScreenNavComposable> {
        QuotesScreenNavComposableImpl()
    }
}

