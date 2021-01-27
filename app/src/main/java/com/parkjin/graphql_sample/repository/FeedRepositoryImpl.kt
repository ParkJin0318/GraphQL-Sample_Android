package com.parkjin.graphql_sample.repository

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.rx2.rxQuery
import com.parkjin.graphql_sample.FeedResultQuery
import io.reactivex.Observable

class FeedRepositoryImpl(
    private val apolloClient: ApolloClient
): FeedRepository {

    override fun getFeeds(): Observable<FeedResultQuery.Data> =
        apolloClient.rxQuery(FeedResultQuery()).map { it.data }
}