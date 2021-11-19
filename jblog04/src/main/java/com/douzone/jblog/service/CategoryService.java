package com.douzone.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.dto.CategoryDto;
import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.repository.CategoryRepository;
import com.douzone.jblog.vo.CategoryVo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired 
	private BlogRepository blogRepository;
	 
	
	public boolean addcat(CategoryVo vo) {
		return categoryRepository.insert(vo);
	}
	
	public List<CategoryDto> getCategoryList(String blog_id) {
		return categoryRepository.findByblogID(blog_id);
	}
	
	// 카테고리에 글 있을경우 글 삭제 후 카테고리 삭제
	public boolean delcat(int no) {
		blogRepository.delpost(no);
		return categoryRepository.delete(no);
		
	}
}
