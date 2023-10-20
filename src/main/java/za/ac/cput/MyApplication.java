package za.ac.cput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
//import za.ac.cput.config.RsaKeyProperties;

import java.security.Principal;


@SpringBootApplication
@RestController
// @EnableConfigurationProperties(RsaKeyProperties.class)
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

}
