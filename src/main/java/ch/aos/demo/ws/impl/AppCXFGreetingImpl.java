package ch.aos.demo.ws.impl;

import javax.jws.WebService;

import ch.aos.demo.ws.AppCXFGreeting;

@WebService(endpointInterface = "ch.aos.demo.ws.AppCXFGreeting")
public class AppCXFGreetingImpl implements AppCXFGreeting {

	@Override
	public String hoi(String text) {
		return "Server is saying hello to " + text;
	}
}