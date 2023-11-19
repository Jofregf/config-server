package api.portfoliojofregf.vercel.hotelsserver.service;

import api.portfoliojofregf.vercel.hotelsserver.model.Hotel;

import java.util.List;

public interface IHotelService {
    public List<Hotel> getHotelByCityId(Long city_id);
}
