package patti.philippe.recap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class RecapApplication {

	public static void main(String[] args) {
		log.info("Hello from the other side");
		SpringApplication.run(RecapApplication.class, args);
	}

}
