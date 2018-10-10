package suulServer;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class Myfilter extends ZuulFilter{

	private static Logger log = Logger.getLogger(Myfilter.class);
	
	@Override
	public Object run() {
		// TODO Auto-generated method stub
		RequestContext rtc  = RequestContext.getCurrentContext();
		HttpServletRequest request = rtc.getRequest();
		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		if(accessToken == null){
			log.warn("token is empty");
			rtc.setSendZuulResponse(false);
			rtc.setResponseStatusCode(401);
			try {
				rtc.getResponse().getWriter().write("token is empty");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		log.info("ok");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
