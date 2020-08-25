package kr.ac.kopo.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.board.vo.BoardVO;

@Repository // 데이터베이스를 access해서 CRUD해주는 DAO 클래스들의 객체 생성을 위한 어노테이션
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
	public BoardVO selectByNo(int no) {
		BoardVO board = sqlSession.selectOne("board.dao.BoardDAO.selectByNo", no);
		return board;
	}
	
	@Override
	public void insert(BoardVO boardVO) {
		sqlSession.insert("board.dao.BoardDAO.insert", boardVO);
	}

}
