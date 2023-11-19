package api.portfoliojofregf.vercel.citiesserver.service;

import api.portfoliojofregf.vercel.citiesserver.dto.CityRecord;

public interface ICityService {
    public CityRecord getCitiesHotels(String name, String country);
}
