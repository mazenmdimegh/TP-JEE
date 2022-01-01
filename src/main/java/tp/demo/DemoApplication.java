package tp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import tp.demo.Entities.Delivery;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {SpringApplication.run(DemoApplication.class, args);    }
    @Override
    public void  run(String... args)throws Exception{
        restConfiguration.exposeIdsFor(Delivery.class);
    }

}
