package com.douzone.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/jblog")
public class BlogController {

	@RequestMapping(value = "", method=RequestMethod.GET)
	public String blogMain() {
		return "blog/blog-main";
	}
	
	@RequestMapping(value = "blogAdminBasic", method=RequestMethod.GET)
	public String blogAdminBasic() {
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping(value = "blogAdminCategory", method=RequestMethod.GET)
	public String blogAdminCategory() {
		return "blog/blog-admin-category";
	}
	
	@RequestMapping(value = "write", method=RequestMethod.GET)
	public String write() {
		return "blog/blog-admin-write";
	}
}
