package edu.fudan.demo.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(req);
		System.out.println("Request::getParameter(addr) is: "+ req.getParameter("addr"));
		String queryString = req.getQueryString();
		System.out.println("queryString is: "+queryString);
		String[]  params = queryString.split("[=]");
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put(params[0], params[1]);
		System.out.println("Map::get(addr) is: "+map.get(params[0]));
		return;
	}
	
	protected void doGet123000(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println(req);
		System.out.println("Req get parameter: "+req.getParameter("addr"));
		//req.setCharacterEncoding("utf-8");
		String url = URLDecoder.decode(req.getQueryString(), "utf-8");
		System.out.println("url: "+url);
		String[]  params = url.split("[=]");
		//System.out.println(params);
		//String addr = req.getParameter("addr");
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put(params[0], params[1]);
		System.out.println("Addr: "+map.get(params[0]));
		return;
	}

	
	public void test(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException{
		System.out.println("Req get parameter addr: "+req.getParameter("addr"));
		String url = req.getQueryString();
		System.out.println("url: "+url);
		String[]  params = url.split("[=]");
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put(params[0], params[1]);
		System.out.println("Map get key addr: "+map.get(params[0]));
		return;
	}
}
