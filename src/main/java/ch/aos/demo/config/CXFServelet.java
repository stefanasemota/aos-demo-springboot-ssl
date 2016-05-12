package ch.aos.demo.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import ch.aos.demo.ws.impl.AppCXFGreetingImpl;

/**
 * Webservice in cfx
 * 
 * @author aos
 *
 */
@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class CXFServelet {
	public static final String SERVICE_NAME_URL_PATH = "/AppCXFGreeting";

	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new CXFServlet(), "/api/*");
	}

	@Bean
	public EndpointImpl appCXFGreeting() {
		Bus bus = (Bus) applicationContext.getBean(Bus.DEFAULT_BUS_ID);
		Object implementor = new AppCXFGreetingImpl();
		EndpointImpl endpoint = new EndpointImpl(bus, implementor);
		endpoint.publish(SERVICE_NAME_URL_PATH);
		return endpoint;
	}
}
