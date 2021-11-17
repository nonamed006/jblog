package com.douzone.jblog.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.jblog.dto.CategoryDto;
import com.douzone.jblog.security.Auth;
import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.service.CategoryService;
import com.douzone.jblog.service.FileUploadService;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;
import com.douzone.jblog.vo.BlogVo;

@Controller
@RequestMapping("/jblog")
public class BlogController {

	@Autowired
	private CategoryService categoryService;	
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private FileUploadService fileUploadService;
	// 젤 처음 = 0 / 모든 카테고리 선택 안 된 상태
	// 1
	@RequestMapping(value = "{id}/{cat}/{no}", method=RequestMethod.GET)
	public String blogMain(@PathVariable("id") String id,
							@PathVariable("cat") int cat,
							@PathVariable("no") int no, Model model) {
		System.out.println(id);
		
		PostVo vo = new PostVo();
		vo.setUser_id(id);
		vo.setCategory_no(cat);
		
		// key:value 한 쌍씩 된 거 
		// K key의 타입 / V value의 타입
		// category_no : 1 or "%"
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category_no", cat == 0 ? "%" : cat);
		map.put("user_id", id);
		map.put("no", no == 0 ? "%" : no);
		
		List<PostVo> postlist = blogService.list(map);
		List<CategoryDto> catlist = categoryService.getCategoryList(id);
		BlogVo blogvo = blogService.findById(id);

		
		
		PostVo mainpost = blogService.findpost(map);
		
		System.out.println(mainpost);
		
		model.addAttribute("postlist", postlist);
		model.addAttribute("catlist", catlist);
		model.addAttribute("mainpost", mainpost);
		model.addAttribute("cat", cat);
		model.addAttribute("no", no);
		model.addAttribute("blogvo", blogvo);
		
		return "blog/blog-main";
	}
	
	@Auth
	@RequestMapping(value = "{id}/blogAdminBasic", method=RequestMethod.GET)
	public String blogAdminBasic(@PathVariable("id") String id, Model model) {
		
		BlogVo blogvo = blogService.findById(id);
		model.addAttribute("blogvo", blogvo);
		
		return "blog/blog-admin-basic";
	}
	
	@Auth
	@RequestMapping(value = "{id}/blogAdminCategory", method=RequestMethod.GET)
	public String blogAdminCategory(@PathVariable("id") String id, Model model) {
		
		List<CategoryDto> catlist = categoryService.getCategoryList(id);
		
		BlogVo blogvo = blogService.findById(id);
		model.addAttribute("blogvo", blogvo);
		
		model.addAttribute("catlist", catlist);
		return "blog/blog-admin-category";
	}
	
	@RequestMapping(value = "blogAdminCategory", method=RequestMethod.POST)
	public String blogAdminCategory(@Valid CategoryVo vo) {
		return "blog/blog-admin-category";
	}
	
	@Auth
	@RequestMapping(value = "{id}/write", method=RequestMethod.GET)
	public String write(@PathVariable("id") String id, Model model) {
		
		List<CategoryDto> list = categoryService.getCategoryList(id);
		
		BlogVo blogvo = blogService.findById(id);
		model.addAttribute("blogvo", blogvo);
		
		model.addAttribute("list", list);
		
		return "blog/blog-admin-write";
	}
	
	@Auth
	@RequestMapping(value = "{id}/write", method=RequestMethod.POST)
	public String write(@PathVariable("id") String id, @Valid PostVo vo) {
		
		vo.setUser_id(id);
		blogService.write(vo);
		return "redirect:/jblog/"+id+"/write";
	}
	
	@Auth
	@RequestMapping(value = "{id}/blogAdminBasic", method=RequestMethod.POST)
	public String blogAdminBasicfileupload(@RequestPart(value="logo-file",required = false)  MultipartFile file, @PathVariable("id") String blogId, BlogVo blogVo) {
		
		String url =null;
		blogVo.setId(blogId);
		
		if(!file.isEmpty()) {
			url = fileUploadService.restoreImage(file);
		} else {
			blogService.updatetitle(blogVo);
		}
		
		blogVo.setLogo(url);
		blogService.update(blogVo);
		
		return "blog/blog-admin-basic";
	}

}


