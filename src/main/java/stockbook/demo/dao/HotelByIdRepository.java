package stockbook.demo.dao;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelByIdRepository extends CassandraRepository<HotelById, String> {
    @Query("SELECT * FROM hotel_by_id WHERE id = ?0")
    HotelById findHotelById(String id);
}
