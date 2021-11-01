package com.douzone.jblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.jblog.service.UserService;
import com.douzone.jblog.vo.UserVo;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/join", method=RequestMethod.GET)
	public String join() {
		return "user/join";
	}
	
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String join(@Valid UserVo vo) {
		System.out.println("들어옴");
		System.out.println(vo);
		userService.join(vo);
		return "user/joinsuccess";
	}
	
	@RequestMapping("/joinsuccess")
	public String joinsuccess() {
		return "user/joinsuccess";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
}	

/*
1. 주소에 달아서 보낸다
192~~~?a=asd

2. request body에 담아서 보내는 게 있지


*/