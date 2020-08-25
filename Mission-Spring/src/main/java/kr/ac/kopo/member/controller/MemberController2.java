package kr.ac.kopo.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

//@Controller
public class MemberController2 {
	
	@Autowired
	private MemberService memberService;
	
	
//	@RequestMapping(value="/login", method = RequestMethod.GET)
	@GetMapping("/login")
	public String loginForm() {
		return "/login/login";
	}

	/*
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id,
						@RequestParam("password") String password) { //form 태그에서 날라오는 parameter가 많아지면, 이렇게 하나하나 받기보다 VO객체로 받아오는 게 더 낫다.
		System.out.println(id + " : " + password);
	}
	 */
	
	@PostMapping("/login")
	public String login(MemberVO memberVO, HttpSession session) { // 그냥 session 객체를 달라고 하면 됨
//		public String login(MemberVO memberVO, HttpServletRequest request) {
//		System.out.println(memberVO);
		
		// login form에서 사용자가 입력한 id, password는
		// input태그의 name속성의 값과 VO의 멤버변수명이 같으면 자동으로 값이 들어가서 객체가 생성된다.
		MemberVO loginVO = memberService.login(memberVO);
		
		// 로그인 실패
		if(loginVO == null) {
			return "redirect:/login";
		}	
		
		// 로그인 성공
//		HttpSession session = request.getSession();
		session.setAttribute("loginVO", loginVO);
		
		return "redirect:/board";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
}
