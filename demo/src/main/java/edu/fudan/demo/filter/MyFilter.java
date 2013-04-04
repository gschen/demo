package edu.fudan.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		String url = request.getRequestURI();

		String srcAddr = request.getLocalAddr();
		
		/** block specified ip address user  **/
		if("11.0.0.1".equals(srcAddr)){
			System.out.println("Attacking.............");
			response.sendRedirect(request.getContextPath()+"/defender.jsp");
			return;
		}
		System.out.println("Local address: "+request.getLocalAddr());
		
		if ("/demo/test.html".equals(url)){
//			System.out.println("This is the test.html.");
//			System.out.println("context path: "+request.getContextPath());
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			return;
		}else{
//			System.out.println("This is the file: "+url);
		}
		arg2.doFilter(arg0, arg1);
		return;
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
