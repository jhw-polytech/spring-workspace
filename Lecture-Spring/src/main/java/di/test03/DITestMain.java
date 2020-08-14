package di.test03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DITestMain {

	public static void main(String[] args) {

		ApplicationContext container = new GenericXmlApplicationContext("ditest03/beanContainer.xml");
		
		MyCalculator my = (MyCalculator)container.getBean("myCalculator");
		
		my.add();
		my.sub();
		my.mul();
		my.div();
		
	}
}
