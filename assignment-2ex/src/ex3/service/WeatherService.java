package ex3.service;

import ex3.model.WeatherData;

public interface WeatherService {
    WeatherData getWeatherData(String location);
}
