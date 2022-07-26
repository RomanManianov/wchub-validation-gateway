package wchub.validation.gateway.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "wchub.validation")
public class AppLauncher {
    public static void main(String[] args) {
        SpringApplication.run(AppLauncher.class);
    }
}
