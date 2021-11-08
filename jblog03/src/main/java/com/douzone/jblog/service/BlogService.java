package com.douzone.jblog.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.vo.PostVo;
import com.douzone.jblog.vo.BlogVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;
	
	public void write(PostVo vo) {
		blogRepository.insert(vo);
	}
	
	public List<PostVo> list(String id) {
		return blogRepository.findAllById(id);
	}
	
	public PostVo findpost(Map<String, Object> map) {
		return blogRepository.findPost(map);
	}
	public boolean update(BlogVo vo) {
		
		return blogRepository.update(vo); 
	}
	
	public BlogVo findById(String id) {
		return blogRepository.findById(id);
	}
}
