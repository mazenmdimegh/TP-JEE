package tp.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tp.demo.Entities.Delivery;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource
public interface DeliveryRepository extends JpaRepository<Delivery,Integer> {
}
