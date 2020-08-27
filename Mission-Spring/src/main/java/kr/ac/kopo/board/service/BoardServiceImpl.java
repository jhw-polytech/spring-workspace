package kr.ac.kopo.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO; // 서버에 한 객체만 만들어서 쓰는 개념..?(=/ new 해서 이 클래스에서 찍어내는 것)
	
	@Override
	public List<BoardVO> selectAllBoard() {
		List<BoardVO> boardList = boardDAO.selectAll();		
		return boardList;
	}

	@Override
	public BoardVO selectBoardByNo(int no) {
		BoardVO board = boardDAO.selectByNo(no);
		return board;
	}

}
