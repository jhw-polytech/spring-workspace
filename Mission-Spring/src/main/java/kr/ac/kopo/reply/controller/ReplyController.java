package kr.ac.kopo.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.reply.service.ReplyService;
import kr.ac.kopo.reply.vo.ReplyVO;

//@Controller
@RestController // 컨트롤러의 일종으로써, controller가 life cycle을 관리하는 객체로 들어간다. 
public class ReplyController {
	// 컨트롤러가 갖고있는 값을 sendRedirect 하지 않고 그 자체를 바로 넘겨준다!
	// / 이 ReplyController라는 컨트롤러가 response body 역할을 하겠다
	// @RestController랑 @ResponseBody이랑 원래 같은 기능을 하는데 RC는 클래에 붙고 RB는 메소드에 붙는 애다.
	
	@Autowired
	private ReplyService replyService;	
	
	/*
	 * ResponseBody를 쓰려면 아래처럼 맵핑도 해줘야 한다.
	 * request를 보내면 forward시키지 않고 단순문자열의 배열/json객체/xml 등의 '반환값'을 컨트롤러 자체에서 response를 보낸다.
	@ResponseBody
	@RequestMapping("/resVOListBody.json")
	 */

//	@ResponseBody // 포워드 시키는 주소가 아니라 이 자체의 주소값을 리턴하겠어! >> (추측) @RestController와 역할이 같아 둘다 쓰면 오류남
	@PostMapping("/reply") // /WEB-INF/jsp/reply.jsp 가 없으면 404 에러가 뜬다.
	public void addReply(ReplyVO replyVO) {
//	public void addReply(@PathVariable 를 써주면 ReplyVO replyVO) { --- formdata(header에 들어감) 형태로 써줘야 하므로 여기선 쓰지 않겠음
		// System.out.println("/reply controller 호출 . . ."); // controller가 제대로 호출되는지 확인
		// System.out.println(replyVO);
		
		replyService.insertReply(replyVO);
	}
	
	@GetMapping("/reply/{boardNo}")
	public List<ReplyVO> getList(@PathVariable("boardNo") int boardNo) {
		// System.out.println("조회할 게시물 번호 : " + boardNo);
		
		List<ReplyVO> replyList = replyService.selectAllByBoardNo(boardNo);
		
		return replyList;
	}
	
//	@RequestMapping(value="/reply/{replyNo}", method=RequestMethod.DELETE)
	@DeleteMapping("/reply/{replyNo}")
	public void deleteReply(@PathVariable("replyNo") int replyNo) {
							// @RequestParam("boardNo") int boardNo 이렇게 boardNo도 받아올 수 있다.
		// System.out.println("삭제할 댓글 번호 : " + replyNo);
		replyService.removeReply(replyNo);
	}
	
	@DeleteMapping("/reply/{replyNo}/{boardNo}")
	public void deleteReply(@PathVariable("replyNo") int replyNo
							, @PathVariable("boardNo") int boardNo) {
		System.out.println(replyNo + " : " + boardNo);
		
		ReplyVO replyVO = new ReplyVO();
		replyVO.setNo(replyNo);
		replyVO.setBoardNo(boardNo);
		
		replyService.removeReply(replyVO);
	}
	
	
}
