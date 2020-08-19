package aop.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("aop-anno.xml");
		
		Employee e = context.getBean("programmer", Employee.class);
		e.work();
	}
}
