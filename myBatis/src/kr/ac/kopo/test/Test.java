package kr.ac.kopo.test;

import kr.ac.kopo.dao.BoardDAO;

public class Test {
	
	@org.junit.Test
	public void test() {
		BoardDAO dao = new BoardDAO();
		dao.work();
	}
	
	// junit이란? java Unit 테스트라는 뜻으로, 웹이 모두 완성되기 전에 단계별로 테스트해보는 것

}
