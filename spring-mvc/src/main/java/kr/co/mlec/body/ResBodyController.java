package kr.co.mlec.body;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mlec.form.MemberVO;

@RequestMapping("/ajax")
@Controller
public class ResBodyController {
	
	/* JSON 처리 - List로 VO 객체 리턴 */
	@ResponseBody
	@RequestMapping("/resVOListBody.json")
	public List<MemberVO> resJsonVOListBody() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		for(int i = 1 ; i<=4 ; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("hong");
			vo.setName("홍길동");
			vo.setPassword("1234");
			list.add(vo);
		}
		
		return list;
		
	}
	
	
	
	/* JSON 처리 - List 객체 리턴 */
	@ResponseBody
	@RequestMapping("/resStringListBody.json")
	public List<String> resJsonStringListBody() {
		List<String> list = new ArrayList<String>();
		
		for(int i = 1; i <= 4; i++) {
			list.add(String.valueOf(i));
		}
		
		// 단순 문자열 배열이 나온다.
		return list;
				
	}	
	
	
	/* JSON 처리 - VO 객체 리턴 */
	@ResponseBody
	@RequestMapping("/resVOBody.json")
	public MemberVO resJsonVOBody() {
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setName("홍길동");
		vo.setPassword("1234");
		
		return vo;
	}
	
	
	/* JSON 처리 - Map 객체 리턴 */
	@ResponseBody
	@RequestMapping("/resBody.json")
	public Map<String, String> resJsonBody() {
		
		Map<String, String> result = new HashMap<String, String>();
		
		result.put("id", "hong");
		result.put("name", "홍길동");
		result.put("addr", "서울");
		
		return result;
	}
	
	/* 문자열 응답 */
	@ResponseBody
	@RequestMapping("/resBody.do")
	public String resStringBody() {
		return "OK, 성공";
	}
	
}
