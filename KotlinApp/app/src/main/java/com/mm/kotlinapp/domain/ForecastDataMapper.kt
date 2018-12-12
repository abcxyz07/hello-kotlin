package com.mm.kotlinapp.domain

import com.mm.kotlinapp.Forecast
import com.mm.kotlinapp.ForecastList
import com.mm.kotlinapp.ForecastResult
import java.text.DateFormat
import java.util.*
import com.mm.kotlinapp.domain.model.Forecast as ModelForecast


public class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(
            convertDate(forecast.dt),
            "hah",
            forecast.temp.max.toInt(),
            forecast.temp.min.toInt()
        );
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}