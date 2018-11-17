package by.izone.spring.core.spring;

import by.izone.spring.core.beans.Client;
import by.izone.spring.core.beans.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.time.LocalDateTime;


@Configuration
@PropertySource("classpath:client.properties")

public class AppConfig {
    @Autowired
    private Environment environment;
    @Bean
    public Client client(){
       Client client = new Client(environment.getRequiredProperty("id"),environment.getRequiredProperty("name"));
       client.setGreeting(environment.getProperty("greeting"));
       return client;
    }
    @Bean
    @Scope("prototype")

    public Event event(){
        return new Event(LocalDateTime.now());
    }


}



