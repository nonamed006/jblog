package com.douzone.jblog.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.jblog.dto.CategoryDto;
import com.douzone.jblog.security.Auth;
import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.service.CategoryService;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;

@Controller
@RequestMapping("/jblog")
public class BlogController {

	@Autowired
	private CategoryService categoryService;	
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value = "{id}", method=RequestMethod.GET)
	public String blogMain(@PathVariable("id") String id, Model model) {
		System.out.println(id);
		
		List<PostVo> postlist = blogService.list(id);
		List<CategoryDto> catlist = categoryService.getCategoryList(id);
		
		model.addAttribute("postlist", postlist);
		model.addAttribute("catlist", catlist);
		
		return "blog/blog-main";
	}
	
	@Auth
	@RequestMapping(value = "{id}/blogAdminBasic", method=RequestMethod.GET)
	public String blogAdminBasic() {
		
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping(value = "{id}/blogAdminCategory", method=RequestMethod.GET)
	public String blogAdminCategory(@PathVariable("id") String id, Model model) {
		
		List<CategoryDto> catlist = categoryService.getCategoryList(id);
		
		model.addAttribute("catlist", catlist);
		return "blog/blog-admin-category";
	}
	
	@RequestMapping(value = "blogAdminCategory", method=RequestMethod.POST)
	public String blogAdminCategory(@Valid CategoryVo vo) {
		return "blog/blog-admin-category";
	}
	
	@RequestMapping(value = "{id}/write", method=RequestMethod.GET)
	public String write(@PathVariable("id") String id, Model model) {
		
		List<CategoryDto> list = categoryService.getCategoryList(id);
		
		model.addAttribute("list", list);
		
		return "blog/blog-admin-write";
	}
	
	@RequestMapping(value = "{id}/write", method=RequestMethod.POST)
	public String write(@PathVariable("id") String id, @Valid PostVo vo) {
		
		System.out.println(vo);
		blogService.write(vo);
		return "redirect:/jblog/write/"+id;
	}

}

/*
	저장하기 누르면 - dispatcherServlet => title, category, contents 
	url에 해당하는 controller의 함수 실행 
	write(@PathVariable("id") String id, @Valid PostVo vo)
	url : write/{id} // id 넣어줘
	PostVo를 넣어달래 // setter들의 이름에 맞는 변수가 있으면 다 넣어줘 // setTitle, setCategory
	PostVo를 완성해서 넣어줘 
*/
