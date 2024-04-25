package ex3;

import ex3.adapter.WeatherAPIAdapter;
import ex3.model.WeatherData;
import ex3.service.ExternalWeatherAPI;
import ex3.service.OpenWeatherMapAPI;
import ex3.service.WeatherService;

public class Main {
    public static void main(String[] args) {
        ExternalWeatherAPI externalAPI = new OpenWeatherMapAPI();
        WeatherService weatherService = new WeatherAPIAdapter(externalAPI);

        // Получение данных о погоде через адаптер
        WeatherData weatherData = weatherService.getWeatherData("New York");

        // Использование данных о погоде
        System.out.println("Temperature: " + weatherData.getTemperature());
        System.out.println("Description: " + weatherData.getDescription());
    }
}
