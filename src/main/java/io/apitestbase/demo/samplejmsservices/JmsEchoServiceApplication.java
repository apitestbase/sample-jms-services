package io.apitestbase.demo.samplejmsservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class JmsEchoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmsEchoServiceApplication.class, args);
    }

}
