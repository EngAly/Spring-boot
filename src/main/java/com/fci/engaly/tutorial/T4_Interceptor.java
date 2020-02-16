package com.fci.engaly.tutorial;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ---------all requests and resposes will pass about this Component ---------
 * To work with interceptor, you need to create @Component class that supports
 * it and it should implement the HandlerInterceptor interface.
 * 
 * The following are the three methods you should know about while working on
 * Interceptors −
 * 
 * preHandle() method − This is used to perform operations before sending the
 * request to the controller. This method should return true to return the
 * response to the client.
 * 
 * postHandle() method − This is used to perform operations before sending the
 * response to the client.
 * 
 * afterCompletion() method − This is used to perform operations after
 * completing the request and response. Intercepter for all requests and
 * responses this is performed on all requests and responses.
 */
@Component
public class T4_Interceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// System.out.println("perform operations before sending the request to
		// the controller");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// System.out.println("perform operations before sending the response to
		// the client");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// System.out.println("perform operations after completing the request
		// and response");
	}
}

/**
 * You will have to register this Interceptor with InterceptorRegistry by using
 * WebMvcConfigurerAdapter as shown below −
 */
@Component
@SuppressWarnings("deprecation")
class T41_InterceptorAppConfig extends WebMvcConfigurerAdapter {

	@Autowired
	T4_Interceptor appinterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(appinterceptor);
	}
}
