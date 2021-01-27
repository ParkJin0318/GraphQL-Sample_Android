package com.parkjin.graphql_sample.repository

import com.parkjin.graphql_sample.FeedResultQuery
import io.reactivex.Observable

interface FeedRepository {

    fun getFeeds(): Observable<FeedResultQuery.Data>
}