package ch.aos.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Specific Application config
 * 
 * @author aos
 *
 */
@Configuration
@Import({ CommonConfig.class, AppContainer.class, AppWebSecurityConfig.class,
		AppBeansConfig.class, CXFServelet.class })
public class AppConfig {

}