package com.red.one.haufe;

import com.red.one.haufe.entities.BeverageEntity;
import com.red.one.haufe.repositories.BeverageRepository;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories("com.red.one.haufe.repositories")
@EntityScan("com.red.one.haufe.entities")
public class ECommApplication {
    @Autowired
    private BeverageRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ECommApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            repository.save(new BeverageEntity(LocalDate.now(), LocalDate.now(), UUID.randomUUID(),1,3453L,42.3, "EURP",1));
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
}
