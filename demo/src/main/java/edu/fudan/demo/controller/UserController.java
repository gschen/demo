package edu.fudan.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.fudan.demo.pojo.User;




@Controller
public class UserController {

	@RequestMapping(value="userlist")
	public String test(Model model){
		
		List<User> userlist = new ArrayList<User>();
		userlist.add(new User("aaaa", "222"));
		
		userlist.add(new User("bbbb", "33333"));
		
		model.addAttribute("users", userlist);
		return "userlist";
	}
}
