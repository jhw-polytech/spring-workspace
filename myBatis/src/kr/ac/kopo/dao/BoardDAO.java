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

	private SqlSession session; // session 객체를 가지고와야 한다.

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

	// 외부에서 접근 못하고 work()로만 접근 가능하게 private 써줌
	// 꼭 이렇게 하지 않아도 됨! 교수님이 쓰시는 방법임
	private void insert() {
		BoardVO board = new BoardVO();
		board.setTitle("삽입연습 . . .");
		board.setWriter("user");
		board.setContent("VO 이용하여 삽입 . . .");

		session.insert("dao.BoardDAO.insertBoard", board);
		session.commit();

		System.out.println("삽입완료. . .");
	}

	private void select() {
		// BoardVO board = session.selectOne("dao.BoardDAO.selectBoard");
		// resultType을 boardVO로 해두었기 때문에 명시적 형변환이 필요 없다.

		List<BoardVO> list = session.selectList("dao.BoardDAO.selectBoard");

		for (BoardVO board : list) {
			System.out.println(board);
		}
	}

	private void selectOne() {
		// 24번 게시글 조회

		// selectByNo - 매개변수가 int
		// BoardVO board = session.selectOne("dao.BoardDAO.selectByNo", 1);

		// selectByNo2 - 매개변수가 VO
		BoardVO vo = new BoardVO();
		vo.setNo(1);
		// BoardVO board = session.selectOne("dao.BoardDAO.selectByNo2", vo);

		// selectByNo3
		BoardVO board = session.selectOne("dao.BoardDAO.selectByNo3", vo);
		System.out.println(board);
	}

	private void selectWhere() {
		BoardVO vo = new BoardVO();

		// 방법1. 제목이 "hi", 작성자가 "kim"인 게시물 조회
		// where title = 'hi' and writer = 'user'
//		vo.setTitle("hi");
//		vo.setWriter("kim");

		// 방법2. 제목이 "hi"인 게시물 조회
		// where title = 'hi'
//		vo.setTitle("hi");

		// 방법3. 작성자가 "user"인 게시물 조회
		// where writer = 'user'
		vo.setWriter("user");

		List<BoardVO> list = session.selectList("dao.BoardDAO.selectWhere", vo);
		for (BoardVO board : list) {
			System.out.println(board);
		}
	}

	private void selectWhere2() {
		// 제목이 '제목'으로 시작하고, 사용자가 'user'인 게시물 조회
		BoardVO vo = new BoardVO();
		vo.setTitle("제목");
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

	@Test // org.junit의 Test 어노테이션을 달면 selectMap2()만 테스트 해볼거라는 뜻
	private void selectMap2() {
		// 15번 게시물 조회
//		BoardVO board = session.selectOne("dao.BoardDAO.selectMap2", 15);
//		System.out.println(board);
		Map<String, Object> map = session.selectOne("dao.BoardDAO.selectMap2", 15);
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}

	}
}
