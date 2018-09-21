package st.demo;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class DemoAccessFilter extends ZuulFilter {

	private static Logger logger = Logger.getLogger(DemoAccessFilter.class.getName());

	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		logger.info("send " + request.getMethod() + " request to " + request.getRequestURL().toString());
		
		Object accessToken = request.getParameter("accessToken");
		if (accessToken == null) {
			logger.warning("access token is empty");
			
			// disable the routing in zuul
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
			return null;
		}

		logger.info("access token is ok");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// filter all the requests
		return true;
	}

	@Override
	public int filterOrder() {
		// execution order in a specific stage
		return 0;
	}

	@Override
	public String filterType() {
		// execute before routing
		return "pre";
	}

}
