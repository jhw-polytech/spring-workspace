package kr.ac.kopo.dao;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.MyConfig;
import kr.ac.kopo.vo.BoardVO;

public class BoardDAO {
	
	private SqlSession session; // session 객체를 가지고와야 한다.
	
	public BoardDAO() {
		this.session = new MyConfig().getInstance();
		System.out.println("session : " + session);
	}
	
	public void work() {
		BoardVO board = new BoardVO();
		board.setTitle("삽입연습 . . .");
		board.setWriter("user");
		board.setContent("VO 이용하여 삽입 . . .");
		
		session.insert("dao.BoardDAO.insertBoard", board);
		session.commit();
		
		System.out.println("삽입완료. . .");
	}
}
