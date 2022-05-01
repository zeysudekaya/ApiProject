package com.example.apiproject.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apiproject.model.Response
import com.example.apiproject.service.PublicApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ResponseViewModel(application: Application) : BaseViewModel(application) {

    private val QuakeAPISer = PublicApiService()
    private val disposable = CompositeDisposable()

    private val _quakeListLiveData = MutableLiveData<Response>()
    val quakeListLiveData : LiveData<Response> = _quakeListLiveData

    fun quakeList(){
        disposable.add(
            QuakeAPISer.getDataService()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Response>() {
                    override fun onSuccess(response: Response) {
                        _quakeListLiveData.value = response
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }
}