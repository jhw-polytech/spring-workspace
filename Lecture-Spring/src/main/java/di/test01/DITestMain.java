package di.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DITestMain {

	public static void main(String[] args) {
		
		/* ===> 아래 객체생성 과정을 xml에서 대체
		Calculator c = new Calculator();
		MyCalculator my = new MyCalculator(c);
		*/
		
		ApplicationContext container = new GenericXmlApplicationContext("ditest01/beanContainer.xml");
		MyCalculator my = (MyCalculator)container.getBean("myCal");
		
		my.setFirstNum(15);
		my.setSecondNum(4);
		
		my.add();
		my.sub();
		my.mul();
		my.div();		
		
	}
}
