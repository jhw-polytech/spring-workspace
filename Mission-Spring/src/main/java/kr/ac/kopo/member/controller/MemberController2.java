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
	
	@PostMapping
	public String login(MemberVO memberVO, HttpSession session) { // 그냥 session 객체를 달라고 하면 됨
//		public String login(MemberVO memberVO, HttpServletRequest request) {
//		System.out.println(memberVO);
		
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
