package kr.co.mlec.form;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/form")
@Controller
public class MemberController {

//	@RequestMapping("/form/joinForm.do")
//	@RequestMapping("/form/join.do")
	@RequestMapping("/joinForm.do")
	public String joinForm() {
		return "form/joinForm";
		// uri와 jsp파일 이름이 같으므로 public void joinForm() {} 이라고 써도 되지만, 가능한 모두 명시해주는 게 좋다.
	}
		
	
	
	@RequestMapping("/join.do")
	public String join(@ModelAttribute("member") MemberVO member) { // 자동으로 등록되는 memberVO라는 이름 대신, member라는 이름으로 객체를 만들겠다.
//	public String join(MemberVO member) {
		// 스프링은 전달받은 객체(여기선 MemberVO) 타입에서 첫번째 글자를 소문자로 바꾼 것을 이름으로 하는 객체를 무조건 등록한다.
		// 즉, mav.addObject("memberVO", member) 를 자동으로 해주고, 공유 영역에도 등록시켜준다.
		
		System.out.println(member);
				
		return "form/memberInfo";
	}

	/*
	 * @RequestMapping("/join.do") public ModelAndView join(MemberVO member) {
	 * 
	 * System.out.println(member);
	 * 
	 * ModelAndView mav = new ModelAndView(); mav.setViewName("form/memberInfo");
	 * mav.addObject("member", member);
	 * 
	 * return mav; }
	 */
	
	/*
	@RequestMapping("/join.do")
	public String join(@RequestParam("id") String id,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			HttpServletRequest request) {

		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		
		request.setAttribute("member", member);
		
		System.out.println(member);
		
		return "form/memberInfo";
	}
	*/
	
	/*
	 * ModelAndView 객체에 
	@RequestMapping("/join.do")
	public ModelAndView join(@RequestParam("id") String id,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			HttpServletRequest request) {
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form/memberInfo");
		mav.addObject("member", member);
		
		return mav;
	}
	*/
	
	/*
	public String join(HttpServletRequest request) {
	// 넘어온 parameter들을 뽑아내기 위해선 request 객체가 필요한데, DispatcherServler이 ??? 하므로???
	// request 객체를 인자로 넘기길 요구하면 Spring이 알아서 준다.
	
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		// String으로 하나하나 넘기는 것보단 MemberVO 객체로 전달하는 게 훨씬 편함
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		
		request.setAttribute("member", member);
		
		System.out.println(member);
		
		return "form/memberInfo";
	}
	*/
	
}
