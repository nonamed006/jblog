package com.douzone.jblog.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
}
/*
	Interceptor
	- DispatcherServlet - Controller(Method)
	  걸려서 Interceptor에 들어가면 원래 목적이었던 Method의 정보를 갖고 있어
	  원래 목적 Method가   @Auth
	                     public void test()
	1. Auth전용 Interceptor를 하나 만든다
		1. spring-servlet에서 만든 Interceptor 등록
		2. 모든 경로에서 Interceptor 타도록 등록
		3. 그럼 무조건 해당 Interceptor 탄다
	2. Interceptor를 탈 때 Method에서 @Auth Annotaion이 있는지 없는지 체크를 해
		Auth의 목적
		- 해당 Method가 로그인을 한지 안 한지 체크 해야해 / 내가 블로그 주인인지 체크
		1. @Auth가 있으면 위에 체크를 해 
*/