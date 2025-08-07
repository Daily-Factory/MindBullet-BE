package hackathon.mindbullet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MindbulletApplication {

    public static void main(String[] args) {
        SpringApplication.run(MindbulletApplication.class, args);
    }

}
