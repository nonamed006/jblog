package com.douzone.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.vo.PostVo;

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
}
