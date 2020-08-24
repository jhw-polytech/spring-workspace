package kr.ac.kopo.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/board")
	public ModelAndView list() {		
		List<BoardVO> boardList = boardService.selectAllBoard();
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("boardList", boardList); // 공유영역에 올리기
		
		return mav;		
	}
	
	// http://localhost:9999/Mission-Spring/board/detail?no=12
	@RequestMapping("/board/{no}") // no에 가변적인 값이 오기 때문에 bracelet{}을 써서 나타낼 수 있다.
	public ModelAndView detail(@PathVariable("no") int boardNo) {
		BoardVO board = boardService.selectBoardByNo(boardNo);
		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("board", board);		
		return mav;
	}
	
	// http://localhost:9999/Mission-Spring/board/detail?no=12
	/*
//	public ModelAndView detail(HttpServletRequest request) {
//		int boardNo = Integer.parseInt(request.getParameter("no"));
	@RequestMapping("/board/detail")
	public ModelAndView detail(@RequestParam("no") int boardNo) {
		
		System.out.println("boardNo: " + boardNo);
		
		//BoardVO boardVO = boardService.;
		ModelAndView mav = new ModelAndView("board/list");
		//mav.addObject("boardVO", boardVO); // 공유영역에 올리기
		
		return mav;		
	}
	*/
	
	@RequestMapping("/sample")
	public ModelAndView sample() {		
		List<BoardVO> boardList = boardService.selectAllBoard();		
		ModelAndView mav = new ModelAndView("sample/sample");		
		mav.addObject("boardList", boardList); // 공유영역에 올리기		
		return mav;		
	}

}
