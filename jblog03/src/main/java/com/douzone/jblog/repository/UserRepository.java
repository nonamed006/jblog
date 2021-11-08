package com.douzone.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.UserVo;


@Repository
public class UserRepository {
	@Autowired
	private SqlSession sqlSession;
	
	//회원가입할때 필요 이제 이거 서비스에서 부르셈
	public boolean insert(UserVo vo) {
		int count = sqlSession.insert("user.insert", vo);
		return count == 1;
	}
	
	//가입할때 블로그 만들어줌
	public boolean insertBlog(BlogVo vo) {
		int count = sqlSession.insert("user.insertBlog", vo);
		return count == 1;
	}
	
	public UserVo findByIdAndPassword(String id, String password) {
		Map<String, String> map = new HashMap<>();
		map.put("e", id);
		map.put("p", password);
		
		return sqlSession.selectOne("user.findByIdAndPassword", map);
	}
}
