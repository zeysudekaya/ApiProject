package com.example.apiproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiproject.R
import com.example.apiproject.model.Entries
import kotlinx.android.synthetic.main.result_data_item.view.*


class apiAdapter : RecyclerView.Adapter<apiAdapter.apiViewHolder>() {

    private var apiDataList: ArrayList<Entries.EntriesItem> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = apiViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.result_data_item, parent, false)
    )

    override fun onBindViewHolder(holder: apiAdapter.apiViewHolder, position: Int) {
        holder.bind(apiDataList[position])

    }

    override fun getItemCount(): Int {
        return apiDataList.size
    }


    inner class apiViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(s: Entries.EntriesItem) {
            itemView.tv_api.text = s.aPI
            itemView.tv_category.text = s.category
            itemView.tv_link.text = s.link
        }
    }

    fun setApiData(s: ArrayList<Entries.EntriesItem>) {
        apiDataList.clear()
        apiDataList.addAll(s)
        notifyDataSetChanged()
    }
}

