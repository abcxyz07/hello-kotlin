package com.mm.kotlinapp.domain

import com.mm.kotlinapp.ForecastList
import com.mm.kotlinapp.ForecastRequest


class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}