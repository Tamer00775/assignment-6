package ex3.adapter;

import ex3.model.ExternalWeatherData;
import ex3.model.WeatherData;
import ex3.service.ExternalWeatherAPI;
import ex3.service.WeatherService;

public class WeatherAPIAdapter implements WeatherService {
    private ExternalWeatherAPI externalWeatherAPI;

    public WeatherAPIAdapter(ExternalWeatherAPI externalWeatherAPI) {
        this.externalWeatherAPI = externalWeatherAPI;
    }
    @Override
    public WeatherData getWeatherData(String location) {
        ExternalWeatherData externalData = externalWeatherAPI.fetchWeather(location);
        return transformData(externalData);
    }

    private WeatherData transformData(ExternalWeatherData externalData) {
        double temperature = convertCelsiusToFahrenheit(externalData.getTemperature());
        String description = externalData.getDescription();

        return new WeatherData(temperature, description);
    }

    private double convertCelsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }
}
