package tp.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tp.demo.Entities.Item;


@RepositoryRestResource
public interface ItemRepository extends JpaRepository<Item,Integer> {
}
