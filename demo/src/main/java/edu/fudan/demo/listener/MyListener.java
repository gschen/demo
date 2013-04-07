package edu.fudan.demo.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import edu.fudan.demo.filter.MyFilter;

public class MyListener implements HttpSessionListener {
static Logger log = Logger.getLogger(MyListener.class.getName());
private int onlineCounter = 0;
	@Override
	public void sessionCreated(HttpSessionEvent se) {

		log.info("session created.");
		log.info("online user num: "+(++onlineCounter));
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {

		log.info("session destroyed.");
		log.info("online user num: "+(--onlineCounter));
	}

}
