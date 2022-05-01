package com.example.apiproject

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiproject.databinding.ActivityMainBinding
import com.example.apiproject.model.Entries
import com.example.apiproject.model.Response
import com.example.apiproject.service.PublicApiService
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var apiAdapter =  com.example.apiproject.adapter.apiAdapter()
    private lateinit var binding: ActivityMainBinding
    private var publicApiService = PublicApiService()
    private var apiNameList: ArrayList<String> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pbLoader.visibility = View.VISIBLE


        publicApiService.getDataService()
            .subscribeOn(Schedulers.newThread())
            .subscribeWith(object : DisposableSingleObserver<Entries>() {
                @RequiresApi(Build.VERSION_CODES.O)
                override fun onSuccess(apiler: Entries) {
                    runOnUiThread {
                        apiAdapter.setApiData(apiler)
                        Log.i("response", apiler.toString())
                        binding.pbLoader.visibility = View.GONE
                    }
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            })


        rv_multiTypeList.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rv_multiTypeList.adapter = apiAdapter

    }
}