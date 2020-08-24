package kr.ac.kopo.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.board.vo.BoardVO;

@Repository // 정보를 관리하는 클래스들은 일반적으로 @Repository 를 많이 쓴다 --? 다시 듣기 25분 정도
public class BoardDAOImpl implements BoardDAO {

	@Autowired // 자동주입
	private SqlSessionTemplate sqlSession;
	// SqlSessionTemplate 객체가 필요하다 (spring-mvc.xml에 bean으로 들어가있음)

	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> boardList = sqlSession.selectList("board.dao.BoardDAO.selectAll");
		
		
		
		return boardList;
	}

	@Override
	public void insert(BoardVO board) {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardVO selectByNo(int no) {
		BoardVO board = sqlSession.selectOne("board.dao.BoardDAO.selectByNo", no);
		
		return board;
	}

}
