package com.douzone.jblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.jblog.service.UserService;

@RestController
@RequestMapping("/jblogapi")
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("checkid/{id}")
	public String checkId(@PathVariable("id") String id) {
		
		int result = userService.findById(id);
		if(result == 0) {
			return "ok";
		} else {
			return "fail";
		}
		
	}

}
