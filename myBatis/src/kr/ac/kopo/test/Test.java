package kr.ac.kopo.test;

import kr.ac.kopo.dao.BoardDAO;

public class Test {
	
	@org.junit.Test
	public void test() {
		BoardDAO dao = new BoardDAO();
		dao.work();
	}
	
	// junit�̶�? java Unit �׽�Ʈ��� ������, ���� ��� �ϼ��Ǳ� ���� �ܰ躰�� �׽�Ʈ�غ��� ��

}
