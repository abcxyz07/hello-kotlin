package com.mm.kotlinapp


data class Weather(
    val id: Long,
    val main: String,
    val desc: String,
    val icon: String
)

data class Temperature(
    val day: Float,
    val min: Float,
    val max: Float,
    val night: Float,
    val eve: Float,
    val mor: Float
)

data class Forecast(
    val dt: Long,
    val temp: Temperature,
    val pressure: Float,
    val humidity: Int,
    val weather: List<Weather>,
    val speed: Float,
    val deg: Int,
    val clouds: Int,
    val rain: Float
)

data class ForecastList(
    val city: String,
    val country: String,
    val dailyForecast: List<com.mm.kotlinapp.domain.model.Forecast>
)

data class Coordinates(
    val lon: Float,
    val lat: Float
)

data class City(
    val id: Long,
    val name: String,
    val coord: Coordinates,
    val country: String,
    val population: Int
)

data class ForecastResult(
    val city: City,
    val list: List<Forecast>
)
