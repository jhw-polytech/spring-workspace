package kr.ac.kopo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.ac.kopo.MyConfig;
import kr.ac.kopo.vo.BoardVO;

public class BoardDAO {

	private SqlSession session; // session ��ü�� ������;� �Ѵ�.

	public BoardDAO() {
		this.session = new MyConfig().getInstance();
		System.out.println("session : " + session);
	}

	public void work() {
		// insert();
		// select();
		// selectOne();
		// selectWhere();
		// selectWhere2();
		// selectNos();
		// selectMap();
		 selectMap2();
	}

	// �ܺο��� ���� ���ϰ� work()�θ� ���� �����ϰ� private ����
	// �� �̷��� ���� �ʾƵ� ��! �������� ���ô� �����
	private void insert() {
		BoardVO board = new BoardVO();
		board.setTitle("���Կ��� . . .");
		board.setWriter("user");
		board.setContent("VO �̿��Ͽ� ���� . . .");

		session.insert("dao.BoardDAO.insertBoard", board);
		session.commit();

		System.out.println("���ԿϷ�. . .");
	}

	private void select() {
		// BoardVO board = session.selectOne("dao.BoardDAO.selectBoard");
		// resultType�� boardVO�� �صξ��� ������ ����� ����ȯ�� �ʿ� ����.

		List<BoardVO> list = session.selectList("dao.BoardDAO.selectBoard");

		for (BoardVO board : list) {
			System.out.println(board);
		}
	}

	private void selectOne() {
		// 24�� �Խñ� ��ȸ

		// selectByNo - �Ű������� int
		// BoardVO board = session.selectOne("dao.BoardDAO.selectByNo", 1);

		// selectByNo2 - �Ű������� VO
		BoardVO vo = new BoardVO();
		vo.setNo(1);
		// BoardVO board = session.selectOne("dao.BoardDAO.selectByNo2", vo);

		// selectByNo3
		BoardVO board = session.selectOne("dao.BoardDAO.selectByNo3", vo);
		System.out.println(board);
	}

	private void selectWhere() {
		BoardVO vo = new BoardVO();

		// ���1. ������ "hi", �ۼ��ڰ� "kim"�� �Խù� ��ȸ
		// where title = 'hi' and writer = 'user'
//		vo.setTitle("hi");
//		vo.setWriter("kim");

		// ���2. ������ "hi"�� �Խù� ��ȸ
		// where title = 'hi'
//		vo.setTitle("hi");

		// ���3. �ۼ��ڰ� "user"�� �Խù� ��ȸ
		// where writer = 'user'
		vo.setWriter("user");

		List<BoardVO> list = session.selectList("dao.BoardDAO.selectWhere", vo);
		for (BoardVO board : list) {
			System.out.println(board);
		}
	}

	private void selectWhere2() {
		// ������ '����'���� �����ϰ�, ����ڰ� 'user'�� �Խù� ��ȸ
		BoardVO vo = new BoardVO();
		vo.setTitle("����");
		vo.setWriter("user");
	}

	private void selectNos() {
		int[] nos = { 1, 2, 6, 10, 16, 25 };

		BoardVO vo = new BoardVO();
		vo.setNos(nos);

//		List<BoardVO> list = session.selectList("dao.BoardDAO.selectNos", vo);
//		List<BoardVO> list = session.selectList("dao.BoardDAO.selectNos2", nos);
		List<BoardVO> list = session.selectList("dao.BoardDAO.selectNos3", nos);
		for (BoardVO board : list) {
			System.out.println(board);
		}
	}

	private void selectMap() {
		//
		/*
		 * BoardVO vo = new BoardVO(); vo.setTitle("hi"); vo.setWriter("kim");
		 * session.selectList("dao.BoardDAO.selectMap", vo);
		 */

		Map<String, String> map = new HashMap<String, String>();
		map.put("title", "hi");
		map.put("writer", "kim");

		List<BoardVO> list = session.selectList("dao.BoardDAO.selectMap", map);

		for (BoardVO board : list) {
			System.out.println(board);
		}

	}

	@Test // org.junit�� Test ������̼��� �޸� selectMap2()�� �׽�Ʈ �غ��Ŷ�� ��
	private void selectMap2() {
		// 15�� �Խù� ��ȸ
//		BoardVO board = session.selectOne("dao.BoardDAO.selectMap2", 15);
//		System.out.println(board);
		Map<String, Object> map = session.selectOne("dao.BoardDAO.selectMap2", 15);
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}

	}
}
