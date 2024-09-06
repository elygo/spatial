package uz.location.spatial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"uz.location.spatial.repository"})
@SpringBootApplication(scanBasePackages = "uz.location.spatial")
public class SpatialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpatialApplication.class, args);
	}

}
