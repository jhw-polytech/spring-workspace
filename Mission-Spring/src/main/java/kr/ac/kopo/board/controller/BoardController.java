package kr.ac.kopo.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	/*
	@RequestMapping("/")
	public String home() {
		return "/";
	}
	*/
	
	@RequestMapping("/board")
	public ModelAndView list() {	
		// System.out.println("mapping /board");  -- preHandle() 이후 실행됨
		List<BoardVO> boardList = boardService.selectAllBoard();
		ModelAndView mav = new ModelAndView("board/list"); // viewName을 인자로 넘겼다
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
	
	/*
	 * @RequestMapping("/sample") public ModelAndView sample() { List<BoardVO>
	 * boardList = boardService.selectAllBoard(); ModelAndView mav = new
	 * ModelAndView("sample/sample"); mav.addObject("boardList", boardList); //
	 * 공유영역에 올리기 return mav; }
	 */
	
	
	
	
	@GetMapping("/board/write")
	public String writeForm(Model model) {
		BoardVO board = new BoardVO();
		board.setTitle("hello");
		
		model.addAttribute("boardVO", new BoardVO());
		
		return "board/write";
		
		// 메소드를 void형으로 하고 실행부에 아래와 같이만 써줘도 된다
		// model.addAttribute("boardVO", new BoardVO());
		// 왜냐하면 @GetMapping("/board/write") 안의 uri 앞에 prefix와 postfix가 붙는다고 생각하면 된다.(같은 uri를 찾는다.)
	}
	
	@PostMapping("/board/write")
	public String write(@Valid BoardVO boardVO, BindingResult result) {
		// @Valid를 쓰면 넘어온 값을 validation 하고, 그에대한 결과는 BindingResult 객체가 알고있다.
		// BindingResult : binding 된 result를 알려주는 객체
		
		// System.out.println(boardVO);
		 System.out.println("result: " + result.hasErrors());
		// result.hasErrors(); // 필수입력값이 모두 입력되었으면 에러가 없으므로 false, 빠진 게 있으면 true가 반환된다.
		
		if(result.hasErrors()) {
			System.out.println("오류발생 . . .");
			return "board/write";
		}
		
		boardService.insert(boardVO);
				
		return "redirect:/board";
	}

}
