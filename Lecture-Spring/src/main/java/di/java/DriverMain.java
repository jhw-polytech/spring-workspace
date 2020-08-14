package di.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * XML�� �̿��� SPRING ������ ����
 */

public class DriverMain {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class); // import �ؿ��� �����̶� path�� ���� ������ �ʴ´�.
		// @Configuration ������̼ǿ� �ִ� config������ �о context ��ü�� ������ְڴ�
			
		Car car = context.getBean("car", Car.class); // Ŭ���� �̸��� ù��° ���ڸ� �ҹ��ڷ� ���ְڴ�.
		car.prnTireBrand();
	}
}