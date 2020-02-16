package com.fci.engaly.tutorial;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * A filter is an object used to intercept the HTTP requests and responses of
 * your application. By using filter, we can perform two operations at two
 * instances − Before sending the request to the controller Before sending a
 * response to the client. The following code shows the sample code for a
 * Servlet Filter implementation class with @Component annotation.
 * note that this filter will apply to all requests and responses.
 */
@Component
public class T3_DoFilter2 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse res = (HttpServletResponse) response;
		
//		System.out.println("i filter i recive request before controller ang get response before client");
		
		// res.setStatus(HttpStatus.BAD_REQUEST.value());
		// if (req.getRequestURL().toString().endsWith("/aly")) {
		// res.getOutputStream().println("<h1>-- this is best name in the
		// --</h1>");
		// }
//		System.out.println(req.getRequestURL().toString());
		chain.doFilter(request, response);

	}

}
