package stockbook.demo.service;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import stockbook.demo.dao.HotelById;
import stockbook.demo.dao.HotelByIdRepository;
import stockbook.demo.entities.Hotel;

import java.util.UUID;

@Service
public class HotelService {
    private HotelByIdRepository repository;

    public HotelService(HotelByIdRepository repository) {
        this.repository = repository;
    }

    public Hotel createHotel(Hotel hotel) {
        Preconditions.checkNotNull(hotel);
        Preconditions.checkArgument(StringUtils.hasText(hotel.getName()));
        hotel.setId(UUID.randomUUID().toString());
        HotelById hotelById = new HotelById();
        hotelById.setId(hotel.getId());
        hotelById.setName(hotel.getName());
        repository.save(hotelById);
        return hotel;
    }
}
