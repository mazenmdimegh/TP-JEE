package tp.demo.controllers;

import tp.demo.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("top_customers_order")
    public ResponseEntity<?> topFiveCustomerByOrders() {
        return ResponseEntity.ok(customerRepository.findTopCustomerLimitedBy(5));
    }

    @GetMapping("customers_top_five_spender")
    public ResponseEntity<?> topFiveSpenderCustomer() {
        return ResponseEntity.ok(customerRepository.topCustomerBySpendingLimitedBy(5));
    }

    @GetMapping("customers_weight_order")
    public ResponseEntity<?> customerByOrdersWeight() {
        return ResponseEntity.ok(customerRepository.customerOrderedTotalWeightMoreThan(10));
    }
}

