package ex3.service;

import ex3.model.ExternalWeatherData;

public interface ExternalWeatherAPI {
    ExternalWeatherData fetchWeather(String location);
}
