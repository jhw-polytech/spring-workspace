package kr.ac.kopo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.ac.kopo.dao.BoardDAO;

public class MybatisMain {
	
	public static void main(String[] args) {
		
		/*
		 * �Ʒ� �ڵ带 ���� MyConfig Ŭ������ �����
		String resource = "mybatis-config.xml";
		try {
			InputStream inputStream= Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// System.out.println(sqlSessionFactory);
			
			SqlSession session = sqlSessionFactory.openSession();
			System.out.println(session);
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		BoardDAO dao = new BoardDAO();
	}

}
