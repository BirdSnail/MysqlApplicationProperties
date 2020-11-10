package com.birdsnail.springboot.customconfig;

import com.birdsnail.springboot.customconfig.pojo.UserInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(UserInfo.class)
public class PropertiesStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertiesStoreApplication.class, args);
    }
}
