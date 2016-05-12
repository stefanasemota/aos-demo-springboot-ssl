package ch.aos.demo.config;

import org.springframework.stereotype.Component;

/**
 * Property file validation config
 * 
 * @author aos
 *
 */
@Component
// @ConfigurationProperties(prefix = "sample")
public class AppProperties {
	private String myText;

	public String getMyText() {
		return myText;
	}

	public void setMyText(String mytext) {
		this.myText = mytext;
	}
}