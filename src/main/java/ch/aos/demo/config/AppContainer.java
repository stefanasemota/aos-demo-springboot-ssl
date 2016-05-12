package ch.aos.demo.config;

import java.io.FileNotFoundException;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
/**
 * Embedded tomcat config
 * @author aos
 *
 */
@Configuration
public class AppContainer {

	@Value("${server.ssl.key-store}")
	private String keystore;

	@Value("${server.ssl.key-password}")
	private String pwd;

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer()
			throws FileNotFoundException {
		final String absoluteKeystoreFile = ResourceUtils.getFile(
				"classpath:" + keystore).getAbsolutePath();

		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer factory) {
				if (factory instanceof TomcatEmbeddedServletContainerFactory) {
					TomcatEmbeddedServletContainerFactory containerFactory = (TomcatEmbeddedServletContainerFactory) factory;
					containerFactory
							.addConnectorCustomizers(new TomcatConnectorCustomizer() {
								@Override
								public void customize(Connector connector) {
									connector.setPort(8443);
									connector.setSecure(true);
									connector.setScheme("https");

									Http11NioProtocol proto = (Http11NioProtocol) connector
											.getProtocolHandler();
									proto.setSSLEnabled(true);
									proto.setKeystoreFile(absoluteKeystoreFile);
									proto.setKeystorePass("secret");
									proto.setTruststoreFile(absoluteKeystoreFile);
									proto.setTruststorePass("secret");
								}
							});
				}
			}
		};
	}
}
