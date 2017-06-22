package systems.ab4.workshop.spots;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location,Long> {
    List<Location> findByName(String name);
}
