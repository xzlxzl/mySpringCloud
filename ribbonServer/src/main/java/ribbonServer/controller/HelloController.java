package ribbonServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ribbonServer.service.HelloService;

@RestController
public class HelloController {

	@Autowired
	private HelloService helloService;
	
	@RequestMapping(value="/")
	public String hello(){
		return helloService.getHelloContent();
	}
}
