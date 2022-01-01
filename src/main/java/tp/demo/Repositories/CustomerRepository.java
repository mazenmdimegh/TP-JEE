package tp.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tp.demo.Entities.Customer;

import java.util.List;

@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer,Integer> {

    @Query(value = "SELECT" +
            " concat(C.NAME,' have ordered ',count(O.ID),' times')"
            + " FROM Customers C JOIN ORDERS O on (o.customer_id=c.id)"
            + " Group by C.NAME order by count(O.ID) desc limit ?1", nativeQuery = true)
    List<String> findTopCustomerLimitedBy(int limit);

    @Query(value = "SELECT"
            + " concat(C.NAME,' have spend ',SUM(OD.qty*IT.price),' TND')"
            + " FROM Customers C JOIN ORDERS O on (o.customer_id=c.id)"
            + " Join ORDERS_DETAILS OD on (O.id=OD.order_id) Join ITEMS IT on (IT.id=OD.item_id)"
            + " Group by C.NAME order by count(O.ID) desc limit ?1", nativeQuery = true)
    List<String> topCustomerBySpendingLimitedBy(int limit);

    @Query(value = "SELECT concat(C.NAME,' have bought about ', round(SUM(OD.qty*IT.weight),2),' KG') "
            + "FROM Customers C JOIN ORDERS O on (o.customer_id=c.id) "
            + "Join ORDERS_DETAILS OD on (O.id=OD.order_id)"
            + " Join ITEMS IT on (IT.id=OD.item_id) Group by C.NAME"
            + " having sum(OD.qty*IT.weight) > ?1 order by count(O.ID) desc", nativeQuery = true)
    List<String> customerOrderedTotalWeightMoreThan(int weight);

}
