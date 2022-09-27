package com.telefonica.rickandmorty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
@Slf4j
public class RickandmortyApplication {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        SpringApplication.run(RickandmortyApplication.class, args);
    }

}
