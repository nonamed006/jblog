package com.douzone.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
