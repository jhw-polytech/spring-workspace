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

	// DataSource �׽�Ʈ -- ds�� ��ü�� �ִٸ� null�� �ƴҰ��̴�
	@Ignore // @Test�� �ּ�ó�� �ص� ������, @Ignore ������̼��� Ȱ���� �׽�Ʈ ��󿡼� ���ܽ�ų ���� �ִ�.
	@Test
	public void ds�׽�Ʈ() throws Exception {
		// System.out.println(ds); -- �̷��� �ص� �׽�Ʈ ����
		assertNotNull(ds); // ds�� ���� null�� �ƴϸ� ����! �ƴϸ� ����
		// assertNull(ds); // ds�� ���� null�̸� ����
	}
	
	@Ignore
	@Test
	public void sqlSession�׽�Ʈ() throws Exception {
		assertNotNull(session);
	}
	
	@Test
	public void ��ü�Խñ���ȸ�׽�Ʈ() throws Exception {
		List<BoardVO> list = session.selectList("board.dao.BoardDAO.selectAll");
		
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	
}
