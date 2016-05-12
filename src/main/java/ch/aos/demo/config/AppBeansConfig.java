package ch.aos.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.validation.Validator;

/**
 * Application beans configuration
 * 
 * @author aos
 *
 */
@Configuration
public class AppBeansConfig {

	@Bean
	public AppProperties appProperty() {
		return new AppProperties();
	}

	@Bean
	public Validator configurationPropertiesValidator() {
		return new AppPropertyValidator();
	}

	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
