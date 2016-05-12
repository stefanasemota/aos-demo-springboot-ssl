package ch.aos.demo;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import ch.aos.demo.ws.AppCXFGreeting;
import ch.aos.demo.ws.impl.AppCXFGreetingImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@Ignore
public class AppCXFTest {

	@Autowired
	ApplicationContext ctx;

	@Test
	// @Ignore
	public void testMyWebService() {
		AppCXFGreetingImpl endpoint = new AppCXFGreetingImpl();
		JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
		svrFactory.setServiceClass(AppCXFGreeting.class);
		svrFactory.setAddress("http://localhost:8443/api");
		svrFactory.setServiceBean(endpoint);
		svrFactory.create();

		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(AppCXFGreeting.class);
		factory.setAddress("http://localhost:8443/api");
		AppCXFGreeting client = (AppCXFGreeting) factory.create();

		String response = client.hoi("11");
		Assert.notNull(response);
		Assert.isTrue("Server is saying hello to 11".equals(response));
	}
}
