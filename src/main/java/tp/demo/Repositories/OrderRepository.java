package tp.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tp.demo.Entities.Order;


@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
