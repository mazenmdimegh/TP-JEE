package tp.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tp.demo.Entities.Customer;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
