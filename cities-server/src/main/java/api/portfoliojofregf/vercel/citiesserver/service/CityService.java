package api.portfoliojofregf.vercel.citiesserver.service;

import api.portfoliojofregf.vercel.citiesserver.dto.CityRecord;
import api.portfoliojofregf.vercel.citiesserver.model.City;
import api.portfoliojofregf.vercel.citiesserver.repository.IHotelAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService implements ICityService{
    @Autowired
    private IHotelAPI hotelAPI;

    List<City> cities = new ArrayList<>();

    @Override
    @CircuitBreaker(name="hotels-service", fallbackMethod = "fallbackGetCityHotels")
    @Retry(name="hotels-service")
    public CityRecord getCitiesHotels(String name, String country) {
        City city = this.findCity(name, country);

        assert city != null;
        CityRecord cityRecord = new CityRecord(
                city.getCity_id(),
                city.getName(),
                city.getState(),
                city.getCountry(),
                city.getContinent(),
                hotelAPI.getHotelsByCityId(city.getCity_id()));

        //createException(); // Simulamos el error


        return cityRecord;
    }

    private CityRecord fallbackGetCityHotels(Throwable throwable){
        return new CityRecord(888888888L, "Fallo", "Fallo", "Fallo", "Fallo", null);
    }

    private void createException(){
        throw new IllegalArgumentException("Prueba Resilience y Circuit Breaker");
    }

    private City findCity(String name, String country) {
        this.loadCity();
        for(City c:cities){
            if(c.getName().equals(name)){
                if(c.getCountry().equals(country)){
                    return c;
                }
            }
        }
        return null;
    }

    private void loadCity() {
        cities.add(new City(1L, "Buenos Aires", "Buenos Aires", "Argentina", "South America"));
        cities.add(new City(2L, "Rio de Janeiro", "Rio de Janeiro", "Brazil", "South America"));
        cities.add(new City(3L, "Mendoza", "Mendoza", "Argentina", "South America"));
        cities.add(new City(4L, "New York City", "New York", "United States", "North America"));
        cities.add(new City(5L, "Paris", "Ile-de-France", "France", "Europe"));
        cities.add(new City(6L, "Tokyo", "Tokyo", "Japan", "Asia"));
        cities.add(new City(7L, "Cape Town", "Western Cape", "South Africa", "Africa"));
        cities.add(new City(8L, "Sydney", "New South Wales", "Australia", "Oceania"));
        cities.add(new City(9L, "Moscow", "Moscow", "Russia", "Europe"));
        cities.add(new City(10L, "Dubai", "Dubai", "United Arab Emirates", "Asia"));
    }
}
