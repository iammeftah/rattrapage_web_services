package wav.hmed.microservicepret;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class MicroservicePretApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicePretApplication.class, args);
    }

}
