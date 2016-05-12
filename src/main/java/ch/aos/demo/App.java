package ch.aos.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

import ch.aos.demo.config.AppConfig;

/**
 * Hello world!
 *
 */
@Import(AppConfig.class)
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}