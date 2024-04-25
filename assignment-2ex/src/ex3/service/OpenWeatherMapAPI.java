package ex3.service;

import ex3.model.ExternalWeatherData;
import ex3.service.ExternalWeatherAPI;

public class OpenWeatherMapAPI implements ExternalWeatherAPI {
    @Override
    public ExternalWeatherData fetchWeather(String location) {
        return new ExternalWeatherData(25.0, "Sunny");
    }
}