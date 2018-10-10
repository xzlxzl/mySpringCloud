package ribbonServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@Service
public class HelloService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="helloError")
	public String getHelloContent(){
		return restTemplate.getForObject("http://SERVICE-HELLOWORLD/", String.class);
	}
	
	public String helloError(){
		return "this is a error";
	}
}
