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
	
	/* JSON ó�� - List�� VO ��ü ���� */
	@ResponseBody
	@RequestMapping("/resVOListBody.json")
	public List<MemberVO> resJsonVOListBody() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		for(int i = 1 ; i<=4 ; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("hong");
			vo.setName("ȫ�浿");
			vo.setPassword("1234");
			list.add(vo);
		}
		
		return list;
		
	}
	
	
	
	/* JSON ó�� - List ��ü ���� */
	@ResponseBody
	@RequestMapping("/resStringListBody.json")
	public List<String> resJsonStringListBody() {
		List<String> list = new ArrayList<String>();
		
		for(int i = 1; i <= 4; i++) {
			list.add(String.valueOf(i));
		}
		
		// �ܼ� ���ڿ� �迭�� ���´�.
		return list;
				
	}	
	
	
	/* JSON ó�� - VO ��ü ���� */
	@ResponseBody
	@RequestMapping("/resVOBody.json")
	public MemberVO resJsonVOBody() {
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setName("ȫ�浿");
		vo.setPassword("1234");
		
		return vo;
	}
	
	
	/* JSON ó�� - Map ��ü ���� */
	@ResponseBody
	@RequestMapping("/resBody.json")
	public Map<String, String> resJsonBody() {
		
		Map<String, String> result = new HashMap<String, String>();
		
		result.put("id", "hong");
		result.put("name", "ȫ�浿");
		result.put("addr", "����");
		
		return result;
	}
	
	/* ���ڿ� ���� */
	@ResponseBody
	@RequestMapping("/resBody.do")
	public String resStringBody() {
		return "OK, ����";
	}
	
}
