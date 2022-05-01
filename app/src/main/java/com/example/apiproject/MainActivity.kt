package com.example.apiproject

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiproject.databinding.ActivityMainBinding
import com.example.apiproject.model.Response
import com.example.apiproject.service.PublicApiService
import com.example.apiproject.viewmodel.ResponseViewModel
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var apiAdapter =  com.example.apiproject.adapter.apiAdapter()
    private var dataList: ArrayList<Response.EntriesItem> = arrayListOf()
    private lateinit var binding: ActivityMainBinding
    private lateinit var ResponseViewModel: ResponseViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pbLoader.visibility = View.VISIBLE

        ResponseViewModel = ViewModelProvider(this).get(com.example.apiproject.viewmodel.ResponseViewModel::class.java)
        ResponseViewModel.quakeList()

        observableLiveData()


        rv_multiTypeList.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rv_multiTypeList.adapter = apiAdapter

    }

    private fun observableLiveData() {
        ResponseViewModel.quakeListLiveData.observe(this) {
            it.entries?.forEach {
                apiler ->
                if (apiler != null) {
                    dataList.add(apiler)
                }
            }

        }
    }
}