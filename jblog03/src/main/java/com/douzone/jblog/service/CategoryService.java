package com.douzone.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.CategoryRepository;
import com.douzone.jblog.vo.CategoryVo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public boolean addcat(CategoryVo vo) {
		
		return categoryRepository.insert(vo);
	}
	
	public List<CategoryVo> getCategoryList(String blog_id) {
		return categoryRepository.findByblogID(blog_id);
	}
}
