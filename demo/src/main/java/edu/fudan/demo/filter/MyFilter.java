package edu.fudan.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import edu.fudan.demo.bean.TestBean;

public class MyFilter implements Filter {
	static Logger logger = Logger.getLogger(MyFilter.class.getName());

	private FilterConfig config;

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		String url = request.getRequestURI();
		System.out.println("Request url is: "+request.getRequestURL().toString());

		String srcAddr = request.getLocalAddr();

		/** block specified ip address user **/
		if ("11.0.0.1".equals(srcAddr)) {
			// System.out.println("Attacking.............");
			logger.info("Attacking......................");
			response.sendRedirect(request.getContextPath() + "/defender.jsp");
			return;
		}
		logger.info("Local address: " + request.getLocalAddr());
		// System.out.println("Local address: "+request.getLocalAddr());

		if ("/demo/test.html".equals(url)) {
			// System.out.println("This is the test.html.");
			// System.out.println("context path: "+request.getContextPath());
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			return;
		} else {
			// System.out.println("This is the file: "+url);
		}
		arg2.doFilter(arg0, arg1);

		/** 使用spring中配置的bean **/
		ServletContext context = config.getServletContext();

		ApplicationContext ac = WebApplicationContextUtils
				.getWebApplicationContext(context);
		TestBean testBean = (TestBean) ac.getBean("testBean");

		//System.out.println("TestBean::Name - " + testBean.getName());
		//System.out.println("TestBean：：Password - " + testBean.getPasswd());
		return;
	}

	public void init(FilterConfig arg0) throws ServletException {
		config = arg0;

	}

}
