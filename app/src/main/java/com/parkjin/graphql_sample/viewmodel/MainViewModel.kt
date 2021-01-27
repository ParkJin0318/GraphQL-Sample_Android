package com.parkjin.graphql_sample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.parkjin.graphql_sample.FeedResultQuery
import com.parkjin.graphql_sample.repository.FeedRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val feedRepository: FeedRepository
): ViewModel() {

    val disposable = CompositeDisposable()

    private val _name = MutableLiveData<String>()

    val name: LiveData<String>
        get() = _name

    fun getFeeds() {
        val feedDisposable = feedRepository.getFeeds()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleDetailResponse)

        disposable.add(feedDisposable)
    }

    private fun handleDetailResponse(data: FeedResultQuery.Data) {
        val results = data.characters?.results
        _name.value = results?.get(0)?.name
    }
}