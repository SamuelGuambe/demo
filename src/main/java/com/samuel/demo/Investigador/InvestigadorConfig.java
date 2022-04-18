package com.samuel.demo.Investigador;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class InvestigadorConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            InvestigadorRepositorio repositorio){
        return args->{
            Investigador investigado1 = new Investigador(
                    "Samuel",
                    "samuelguambe1@gmail.com",
                    LocalDate.of(2000, Month.JULY,01)
            );

            Investigador investigado2 = new Investigador(
                    "Adolfo",
                    "adolfo@gmail.com",
                    LocalDate.of(2010, Month.JULY,01)

            );

            repositorio.saveAll(
                    List.of(investigado1, investigado2)
            );

        };
    }
}
