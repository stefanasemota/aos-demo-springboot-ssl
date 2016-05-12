package ch.aos.demo.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * default controller
 * 
 * @author aos
 *
 */
@Controller
public class SampleController {
	@RequestMapping("/")
	@ResponseBody
	public String helloWorld() {
		return "Hello, world";
	}
}
