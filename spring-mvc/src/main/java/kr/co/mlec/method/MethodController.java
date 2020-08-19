package kr.co.mlec.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/method/method.do")
@Controller
public class MethodController {

	/*
	 * 같은 uri에 메소드 방식에 따라 호출되는 게 다르게 움직일 수 있다.
	 * method를 쓰지 않으면 기본이 get 방식
	 * 
	@RequestMapping(value="/method/method.do")
	public String callGet() {
		return "method/methodForm";
	}
	*/

//	@RequestMapping(value="/method/method.do", method=RequestMethod.GET)
	@RequestMapping(method=RequestMethod.GET)
	public String callGet() {
		return "method/methodForm";
	}
	
//	@RequestMapping(value="/method/method.do", method=RequestMethod.POST)
	@RequestMapping(method=RequestMethod.POST)
	public String callPost() {
		return "method/methodProcess";
	}
	
	/*
	 	spring은 우리가 그냥 만든 mvc model보다 훨씬 유연하다.
		return값을 mav가 아니라 string으로 주면 알아서 forward라고 인식한다.
		따라서 return type을 string이라고 써도 에러가 생기지 않는다.
		
		리턴타입이 void인 경우도 있다. 이 경우, uri와 똑같은 경로와 이름의 jsp 타입으로 인식한다.
		ex) /method/method.do -> /method/method.jsp 반환
	 */
	
}
