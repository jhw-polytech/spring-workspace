package aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * Spring AOP Ư¡
 * 1. Runtime ���
 * 2. Proxy ���   ---------------> �ٽ� �޼ҵ�(work())�� ����Ǳ� ��ٸ��� �ִٰ�,
 * 3. Interface ���
 */

public class EmpMain {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("aop-xml.xml");
		// Programmer programmer = (Programmer) context.getBean("programmer");
		// programmer.work();
		Employee e = (Employee) context.getBean("programmer"); // �������̽� ����̹Ƿ� �������̽������� �޾���� ��
		e.work();
		
		e = context.getBean("designer", Employee.class);
		e.work();
		
		e = context.getBean("manager", Employee.class);
		e.work();
	}

}