package kr.ac.kopo.dao;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.MyConfig;
import kr.ac.kopo.vo.BoardVO;

public class BoardDAO {
	
	private SqlSession session; // session ��ü�� ������;� �Ѵ�.
	
	public BoardDAO() {
		this.session = new MyConfig().getInstance();
		System.out.println("session : " + session);
	}
	
	public void work() {
		BoardVO board = new BoardVO();
		board.setTitle("���Կ��� . . .");
		board.setWriter("user");
		board.setContent("VO �̿��Ͽ� ���� . . .");
		
		session.insert("dao.BoardDAO.insertBoard", board);
		session.commit();
		
		System.out.println("���ԿϷ�. . .");
	}
}
