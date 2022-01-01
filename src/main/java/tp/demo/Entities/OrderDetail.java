package tp.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer qty ;
    private Double tax;
    @ManyToOne
    private Order order;
    @ManyToOne
    private Item item ;


    public double calculateTotal(){
        return item.getPrice()*this.qty+this.tax;
    }
    public double calculateWeight(){
        return item.getWeight()*this.qty;
    }

}
