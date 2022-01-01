package tp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import tp.demo.Entities.Delivery;
import tp.demo.Repositories.ItemRepository;
import tp.demo.Repositories.CustomerRepository;
import tp.demo.Repositories.OrderRepository;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {SpringApplication.run(DemoApplication.class, args);
    }
    @Override
    public void  run(String... args)throws Exception{
        restConfiguration.exposeIdsFor(Delivery.class);
    }

}
