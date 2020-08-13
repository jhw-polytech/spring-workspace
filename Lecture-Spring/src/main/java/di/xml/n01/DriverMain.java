package di.xml.n01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * �������� ���� �Ӽ� ����
 */

public class DriverMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("di-xml01.xml");	// xml ���� �о�����
		
		/* ��� 2 */
		Car car = (Car)context.getBean("car2");
		car.prnTireBrand();
		
		
		/*
		Car car = (Car)context.getBean("car");
		Tire tire = (Tire)context.getBean("tire");
		car.setTire(tire);
		
		car.prnTireBrand();
		*/
		
		
		
		/*
		 * ��� 1)
		Car car = new Car();
		
		Tire tire = new HankookTire();
		car.setTire(tire);
		
		car.prnTireBrand();		
		*/		

		
	}
	
}