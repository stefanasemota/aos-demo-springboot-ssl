package ch.aos.demo.config;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Property file validation config
 * 
 * @author aos
 *
 */
public class AppPropertyValidator implements Validator {

	@Override
	public boolean supports(Class<?> type) {
		return AppProperties.class == type;
	}

	@Override
	public void validate(Object o, Errors errors) {
		// ValidationUtils.rejectIfEmpty(errors, "serverssl.key-store",
		// "wrong keystore");
		ValidationUtils.rejectIfEmpty(errors, "myText", "myText.empty");
		AppProperties properties = (AppProperties) o;
		if (properties.getMyText().equals("aaa")) {
			errors.rejectValue("myText", "Invalid myText");
		}
	}
}
