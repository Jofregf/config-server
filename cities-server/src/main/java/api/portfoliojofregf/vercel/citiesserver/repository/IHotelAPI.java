package api.portfoliojofregf.vercel.citiesserver.repository;

import api.portfoliojofregf.vercel.citiesserver.dto.HotelRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="hotels-service")
public interface IHotelAPI {
    @GetMapping("api/hotels/{city_id}")
    public List<HotelRecord> getHotelsByCityId(@PathVariable("city_id") Long city_id);
}
