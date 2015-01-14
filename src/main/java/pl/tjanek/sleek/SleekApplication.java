package pl.tjanek.sleek;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SleekApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleekApplication.class, args);
    }
}
