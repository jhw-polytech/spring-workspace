package kr.ac.kopo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.member.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	
	/* 필터같은 역할을 하는 기능. spring-mvc.xml에 맵핑된 기능들이 실행되기 전에 확인해준다 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// System.out.println("preHandle()...");
		
		// handler는 어떤 Controller의 어떤 method를 호출하는건지 알고있다 >> 로그파일 만들 때 사용할 수 있다. >> log4j를 쓰면 더 쉬움 ㅋㅋ
		HandlerMethod method = (HandlerMethod)handler;
		System.out.println("메소드 : " + method);
		System.out.println("controller : " + method.getBean());
		
		// 로그인 여부 체크
		HttpSession session = request.getSession();
		MemberVO loginVO = (MemberVO)session.getAttribute("loginVO");
		
		// 로그인이 되어있지 않으면 글쓰기 기능으로 보내지 않음
		if(loginVO == null) {
			
			// 요청을 보낸 uri 가지고 오기
			String uri = request.getRequestURI();
			uri = uri.substring(request.getContextPath().length());
			// System.out.println(uri);			
			
			// uri 뒤에 날라오는 parameter도 가지고 오기 ( no=24 형태로 날라옴)
			String query = request.getQueryString();
			System.out.println(query);
			
			// 날라오는 parameter가 있을경우 uri 뒤에 query를 붙여줌
			if(query != null && query.length() != 0)
				uri = uri + "?" + query;
			
			session.setAttribute("dest", uri);
			
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}				

		return true;
	}
	
	
/*
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle()...");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion()...");
		super.afterCompletion(request, response, handler, ex);
	}

*/
	
	
}
