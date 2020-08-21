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

import kr.ac.kopo.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-mvc.xml"})
public class MybatisTest {

	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionTemplate session;

	// DataSource 테스트 -- ds가 객체가 있다면 null이 아닐것이다
	@Ignore // @Test를 주석처리 해도 되지만, @Ignore 어노테이션을 활용해 테스트 대상에서 제외시킬 수도 있다.
	@Test
	public void ds테스트() throws Exception {
		// System.out.println(ds); -- 이렇게 해도 테스트 가능
		assertNotNull(ds); // ds의 값이 null이 아니면 성공! 아니면 실패
		// assertNull(ds); // ds의 값이 null이면 성공
	}
	
	@Ignore
	@Test
	public void sqlSession테스트() throws Exception {
		assertNotNull(session);
	}
	
	@Test
	public void 전체게시글조회테스트() throws Exception {
		List<BoardVO> list = session.selectList("board.dao.BoardDAO.selectAll");
		
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	
}
