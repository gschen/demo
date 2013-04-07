package edu.fudan.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.fudan.demo.filter.MyFilter;


public class MyInterceptor extends HandlerInterceptorAdapter {
	 static Logger logger = Logger.getLogger(MyInterceptor.class.getName());
	private ThreadLocal<StopWatch> stopWatchThreadLocal = new ThreadLocal<StopWatch>();

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("After completion.");
		StopWatch stopWatch = (StopWatch) stopWatchThreadLocal.get();
		stopWatch.stop();
		
		logger.info(request.getContextPath()+"--------------- takes :-----------------------"+stopWatch.getTotalTimeMillis()+" ms.");
		stopWatchThreadLocal.set(null);
		
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Post handler.");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("Pre handler.");
		StopWatch stopWatch = new StopWatch(handler.toString());
		stopWatchThreadLocal.set(stopWatch);
		stopWatch.start();
		return super.preHandle(request, response, handler);
	}

}
