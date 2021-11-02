package com.douzone.jblog.controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.jblog.vo.CategoryVo;

@Controller
@RequestMapping("/jblog")
public class BlogController {

	@RequestMapping(value = "{id}", method=RequestMethod.GET)
	public String blogMain(@PathVariable("id") String id) {
		System.out.println(id);
		
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
	
	@RequestMapping(value = "blogAdminCategory", method=RequestMethod.POST)
	public String blogAdminCategory(@Valid CategoryVo vo) {
		return "blog/blog-admin-category";
	}
	
	@RequestMapping(value = "write", method=RequestMethod.GET)
	public String write() {
		return "blog/blog-admin-write";
	}
	

}
