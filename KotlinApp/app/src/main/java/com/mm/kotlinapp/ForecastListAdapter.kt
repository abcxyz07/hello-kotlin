package com.mm.kotlinapp

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView


class ForecastListAdapter(val weekForecast: ForecastList) :
    RecyclerView.Adapter<ForecastListAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(TextView(parent.context))
    }

    override fun getItemCount(): Int {
        return weekForecast.dailyForecast.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        with(weekForecast.dailyForecast[position]){
            holder.textView.text = "$date - $desc - $max - $min"
        }
    }

    class VH(val textView: TextView) : RecyclerView.ViewHolder(textView)
}