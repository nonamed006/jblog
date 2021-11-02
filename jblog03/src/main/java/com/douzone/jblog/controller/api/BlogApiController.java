package com.douzone.jblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.jblog.service.CategoryService;
import com.douzone.jblog.vo.CategoryVo;

//restController 는 데이터를 리턴해주는 컨트롤러
@RestController
@RequestMapping("/jblogapi")
public class BlogApiController {

	@Autowired
	private CategoryService categoryService;
	// form으로 category name/desc 보내는거랑 ajax로 보내는거랑 다를게 없어
	// 어차피 쟤들은 그냥 request에 실려오는거라서 똑같이 받으면 돼
	// ajax로 json을 보내잖아. 이거는 설정하나 해줘야 돼
	@PostMapping("addcat")
	public String addcategory(@RequestBody CategoryVo vo) {// json으로 오니까 그걸 class로 바꿔서 
		// json은 데이터형 / 쟤를 받아서 그걸 class로 바꿔서 vo에 넣어주는거라서
		// json이라고 알려줘야 해
		// vo에 카테고리가 담기면 그냥 똑같이 insert하면 돼
		// 대신 인서트가 성공했는지 실패했는지 ajax에서는 몰라. 그래서 그걸 판별할 수 있게끔 리턴을 
		// 해줘야 하는데 일단은 너가 성공하면 "ok"를 리턴해 
		
		vo.setBlog_id("asd");
		boolean result = categoryService.addcat(vo);
		
		if(result) {
			return "ok";
		}
		else {
			return "fail";
		}
	}	
}

