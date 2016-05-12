package ch.aos.demo.ws;

import javax.jws.WebService;

@WebService
public interface AppCXFGreeting {
	String hoi(String text);
}