package com.douzone.jblog.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.PostVo;
import com.douzone.jblog.vo.BlogVo;



@Repository
public class BlogRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public boolean insert(PostVo vo) {
		int count = sqlSession.insert("post.insert", vo);
		return count == 1;
	}
	
	public List<PostVo> findAllById(Map<String, Object> map) {
		
		return sqlSession.selectList("post.findAllById", map);
	}
	
	//블로그 메인 글 올려주는 함수
	public PostVo findPost(Map<String, Object> map) {
		return sqlSession.selectOne("post.findPost", map);
	}
	
	//블로그 설정 바꾸기
	public boolean update(BlogVo vo) {
		int count = sqlSession.update("blog.updateProfile", vo);
		return count == 1;
	}
	//제목만 바꾸기
	public boolean updatetitle(BlogVo vo) {
		int count = sqlSession.update("blog.updatetitle", vo);
		return count == 1;
	}
	
	public BlogVo findById(String id){
		return sqlSession.selectOne("blog.findById", id);
	}
	
	//포스트 삭제
	public boolean delpost(int no) {
		int count = sqlSession.delete("post.deletepost", no);
		return count == 1;
	}
	
}
