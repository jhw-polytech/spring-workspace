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
		// uri�� jsp���� �̸��� �����Ƿ� public void joinForm() {} �̶�� �ᵵ ������, ������ ��� ������ִ� �� ����.
	}
		
	
	
	@RequestMapping("/join.do")
	public String join(@ModelAttribute("member") MemberVO member) { // �ڵ����� ��ϵǴ� memberVO��� �̸� ���, member��� �̸����� ��ü�� ����ڴ�.
//	public String join(MemberVO member) {
		// �������� ���޹��� ��ü(���⼱ MemberVO) Ÿ�Կ��� ù��° ���ڸ� �ҹ��ڷ� �ٲ� ���� �̸����� �ϴ� ��ü�� ������ ����Ѵ�.
		// ��, mav.addObject("memberVO", member) �� �ڵ����� ���ְ�, ���� �������� ��Ͻ����ش�.
		
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
	 * ModelAndView ��ü�� 
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
	// �Ѿ�� parameter���� �̾Ƴ��� ���ؼ� request ��ü�� �ʿ��ѵ�, DispatcherServler�� ??? �ϹǷ�???
	// request ��ü�� ���ڷ� �ѱ�� �䱸�ϸ� Spring�� �˾Ƽ� �ش�.
	
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		// String���� �ϳ��ϳ� �ѱ�� �ͺ��� MemberVO ��ü�� �����ϴ� �� �ξ� ����
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
