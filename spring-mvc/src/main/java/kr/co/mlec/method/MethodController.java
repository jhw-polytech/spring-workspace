package kr.co.mlec.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/method/method.do")
@Controller
public class MethodController {

	/*
	 * ���� uri�� �޼ҵ� ��Ŀ� ���� ȣ��Ǵ� �� �ٸ��� ������ �� �ִ�.
	 * method�� ���� ������ �⺻�� get ���
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
	 	spring�� �츮�� �׳� ���� mvc model���� �ξ� �����ϴ�.
		return���� mav�� �ƴ϶� string���� �ָ� �˾Ƽ� forward��� �ν��Ѵ�.
		���� return type�� string�̶�� �ᵵ ������ ������ �ʴ´�.
		
		����Ÿ���� void�� ��쵵 �ִ�. �� ���, uri�� �Ȱ��� ��ο� �̸��� jsp Ÿ������ �ν��Ѵ�.
		ex) /method/method.do -> /method/method.jsp ��ȯ
	 */
	
}
