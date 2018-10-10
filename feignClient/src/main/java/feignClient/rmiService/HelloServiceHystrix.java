package feignClient.rmiService;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceHystrix implements HelloService{

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "this is a error";
	}

}
