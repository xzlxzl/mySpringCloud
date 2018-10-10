package feignClient.rmiService;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="service-helloworld",fallback=HelloServiceHystrix.class)
public interface HelloService {

	@RequestMapping(value="/",method = RequestMethod.GET)
	String sayHello();
}
