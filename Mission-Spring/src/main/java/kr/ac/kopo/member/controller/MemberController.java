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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

// @SessionAttributes({"loginVO"}) // attribute's' -> 배열로 들어올 수 있다
@SessionAttributes("loginVO")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String loginForm() {
		return "/login/login";
	}

	@PostMapping("/login") //RequestMapping 대체
	public ModelAndView login(MemberVO memberVO, HttpSession session) { // 그냥 session 객체를 달라고 하면 됨
		
		MemberVO loginVO = memberService.login(memberVO);
		ModelAndView mav = new ModelAndView();
		
		// 로그인 실패
		if(loginVO == null) {
			mav.setViewName("redirect:/login");
		} else {	
			// 로그인 성공
			String dest = (String)session.getAttribute("dest");
			if(dest == null) {
				mav.setViewName("redirect:/");
			} else {
				mav.setViewName("redirect:/" + dest);				
				session.removeAttribute("dest");
			}					
			
			mav.addObject("loginVO", loginVO); // 이렇게 하면 request 객체에 등록되기 때문에, 아무리 해도 로그인 되지 않는다.
			// 원래 mav들은 request에 등록해주는거임. 그러나 login만큼은 session에 저장시켜야 한다. >> 클래스 위에 @SessionAttributes({"loginVO"})를 써준 이유!
		}
		
		return mav;
	}
	
	@RequestMapping("/logout")
	public String logout(SessionStatus status) {
		// session.invalidate(); ->  @SessionAttributes 를 써서 등록시킨 애는 이걸로 세션에서 삭제시킬 수 없다
		
		status.setComplete(); // 이렇게 세션을 만료시켜줘야 한다 / 세션에 등록된 값들이 초기화된다
		System.out.println(status.isComplete());
		
		return "redirect:/";
	}
}
