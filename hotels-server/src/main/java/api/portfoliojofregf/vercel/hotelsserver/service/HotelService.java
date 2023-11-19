package api.portfoliojofregf.vercel.hotelsserver.service;

import api.portfoliojofregf.vercel.hotelsserver.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService implements IHotelService {
    List<Hotel> hotelsList = new ArrayList<>();

    @Override
    public List<Hotel> getHotelByCityId(Long city_id) {

        List<Hotel> hotelCityLists = new ArrayList<>();

        this.loadHotels();

        for(Hotel h:hotelsList){
            if(h.getCity_id() == city_id){
                hotelCityLists.add(h);
            }
        }

        return hotelCityLists;
    }

    private void loadHotels() {
        hotelsList.add(new Hotel(1L, "Paradise", 5, 1L));
        hotelsList.add(new Hotel(2L, "Sunset View", 4, 2L));
        hotelsList.add(new Hotel(3L, "Cozy Retreat", 3, 1L));
        hotelsList.add(new Hotel(4L, "Mountain Lodge", 5, 3L));
        hotelsList.add(new Hotel(5L, "Ocean Breeze", 2, 2L));
        hotelsList.add(new Hotel(6L, "City Lights Hotel", 4, 1L));
        hotelsList.add(new Hotel(7L, "Green Valley Resort", 3, 3L));
        hotelsList.add(new Hotel(8L, "Tranquil Oasis", 5, 2L));
        hotelsList.add(new Hotel(9L, "Downtown Suites", 2, 1L));
        hotelsList.add(new Hotel(10L, "Riverfront Mansion", 4, 3L));
    }
}
