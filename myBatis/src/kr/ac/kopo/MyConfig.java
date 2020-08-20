package kr.ac.kopo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * Session ��ü�� �ϳ� �е��� �ϴ� �� ��ǥ
 */

public class MyConfig {

	private SqlSession session;
	
	public MyConfig() {
		String resource = "mybatis-config.xml";
		try {
			InputStream inputStream= Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// System.out.println(sqlSessionFactory);
			
			session = sqlSessionFactory.openSession(); // mybatis�� ������ �� �ִ� session ��ü > DAO���� ���޵Ǿ�� �Ѵ�.
			System.out.println(session);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SqlSession getInstance() {
		return session;
	}
	
	
}
