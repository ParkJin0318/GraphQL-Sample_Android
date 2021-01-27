package com.parkjin.graphql_sample.module

import com.apollographql.apollo.ApolloClient
import com.parkjin.graphql_sample.repository.FeedRepository
import com.parkjin.graphql_sample.repository.FeedRepositoryImpl
import com.parkjin.graphql_sample.viewmodel.MainViewModel
import com.parkjin.graphql_sample.widget.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val repositoryModule = module {
    single<FeedRepository> { FeedRepositoryImpl(get()) }
}

val networkModule = module {
    single {
        ApolloClient.builder()
            .serverUrl(Constants.SERVER_URL)
            .okHttpClient(get())
            .build()
    }

    single {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        OkHttpClient.Builder().addInterceptor(interceptor)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS).build()
    }
}