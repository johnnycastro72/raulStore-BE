package com.sofkau.raulstorebe;

import com.sofkau.raulstorebe.mapper.StoreMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RaulStoreBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RaulStoreBeApplication.class, args);
    }
    @Bean
    public StoreMapper StoreMapper() {
        return new StoreMapper();
    }

}
