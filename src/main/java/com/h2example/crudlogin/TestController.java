package com.h2example.crudlogin;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/test")
public class TestController {
	@Value("${injectValue}")
	public String inValue;

	@Value("${url}")
	public String url;

	@Value("${server.port}")
	public int port;
	@Value("${sampleVal}")
	public float flot;

	@GetMapping("/rest")
	public String getRestOP(HttpServletRequest request) {
		System.out.println("rest op hit " + request.getHeader("User-Agent"));
		return "Hello java dev this is rest output";
	}

	@GetMapping("/html")
	public ModelAndView getHtml() {
		ModelAndView mv = new ModelAndView("helloM");
		// ModelAndView mv=new ModelAndView();
		// mv.setViewName("helloM");
		return mv;
	}

	@GetMapping("/err")
	public ModelAndView throwErr() {
		try {
			throw new Exception("my exception");
		} catch (Exception e) {
			ModelAndView mav = new ModelAndView("error/500");
			mav.addObject("message", e.getMessage());
			return mav;
		}
	}

	@GetMapping("/err2")
	public ModelAndView throwErr2() {
		ModelAndView mav = null;
		try {
			Random rand = new Random();
			int b = rand.nextInt(2);
			System.out.println("b=============" + b);
			int a = 10 / b;
			System.out.println(a);
		} catch (Exception e) {
			mav = new ModelAndView("error/500");
			mav.addObject("message", e.getMessage());
			return mav;
		}
		mav = new ModelAndView("add");
		return mav;
	}

	@Value("${warfilename}")
	String war;

	@GetMapping("/injectValue")
	public String retInjectedValue() {
		return war + " " + inValue + " db url: " + url + " serverPort: " + port + " sampleFloatVal : " + flot;
	}
}