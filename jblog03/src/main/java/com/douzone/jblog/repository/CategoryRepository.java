package com.douzone.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.dto.CategoryDto;
import com.douzone.jblog.vo.CategoryVo;

@Repository
public class CategoryRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public boolean insert(CategoryVo vo) {
		int count = sqlSession.insert("category.insert", vo);
		return count == 1;
	}
	
	public List<CategoryDto> findByblogID(String blog_id) {
		return sqlSession.selectList("category.findByblogID", blog_id);
	}
	
	public boolean delete(int no) {
		int count = sqlSession.delete("category.deleteByNo", no);
		return count == 1;
	}
	
}

