 package com.douzone.jblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.jblog.service.UserService;
import com.douzone.jblog.vo.BlogVo;
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
	
	@Transactional //하나 실패하면 알아서 rollback
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String join(@Valid UserVo vo) {
		System.out.println("회원가입 들어옴");
		userService.join(vo);
		
		BlogVo bvo = new BlogVo();
		
		bvo.setId(vo.getId());
		bvo.setTitle(vo.getId());
		bvo.setLogo("/upload/images/cookie.jpg");
		
		userService.insertblog(bvo);
		
		System.out.println("블로그 새로 만들어짐");
		return "user/joinsuccess";
	}
	/*
	  	메소드 어디서 쓰여져 ?
	  	디스패쳐서블릿
	  	join(__userVo____)
	  	달라고 하면 request / userVo의 필드를 찾아서 이름끼리 짝 맞춰서 vo 한개 만들어서 
	  	넣어줘 
	 */
	
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