package kr.ac.kopo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-mvc.xml"})
public class MybatisTest {

	@Autowired // 의존주입을 받아올 수 있는지 테스트
	private DataSource ds;
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private BoardDAO boardDAO; 
	
	@Autowired
	private BoardService boardService;

	// DataSource 테스트 -- ds 객체가 제대로 생성되었는지 테스트! 잘 생성되었다면 null이 아니겠지! 
	@Ignore // @Test를 주석처리해도 되지만, @Ignore 를 붙여도 테스트 대상에서 제외시킬 수 있다.
	@Test
	public void ds테스트() throws Exception {
		// System.out.println(ds); -- ds가 존재하면 찍어준다
		assertNotNull(ds); // ds가 null이 아닐 때 테스트 성공
		// assertNull(ds); // ds가 null일 때 테스트 성공
	}
	
	@Ignore
	@Test
	public void sqlSession테스트() throws Exception {
		assertNotNull(session);
	}
	
	@Ignore
	@Test
	public void 전체게시글조회테스트() throws Exception {
//		List<BoardVO> list = session.selectList("board.dao.BoardDAO.selectAll");
		List<BoardVO> list = boardDAO.selectAll();
		
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	
	@Test
	public void 게시판상세Test() throws Exception {
		BoardVO board = boardDAO.selectByNo(5);
		System.out.println(board);
	}
	
	@Test
	public void 댓글증가Test() throws Exception {
		boardDAO.incrementReplyCnt(1);
	}
	
}
