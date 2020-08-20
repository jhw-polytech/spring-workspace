package kr.ac.kopo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * Session 객체를 하나 읽도록 하는 게 목표
 */

public class MyConfig {

	private SqlSession session;
	
	public MyConfig() {
		String resource = "mybatis-config.xml";
		try {
			InputStream inputStream= Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// System.out.println(sqlSessionFactory);
			
			session = sqlSessionFactory.openSession(); // mybatis와 연동할 수 있는 session 객체 > DAO까지 전달되어야 한다.
			System.out.println(session);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SqlSession getInstance() {
		return session;
	}
	
	
}
