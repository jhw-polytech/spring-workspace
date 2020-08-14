package di.xml.n02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * XML�� �̿��� SPRING ������ ����
 */

public class DriverMain {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("di-xml02.xml");
		
		Car car = (Car)context.getBean("car"); // ������ ������ �Ͼ(xml�� constructor-arg �±� �ȿ� �ִ� ��� Tire�� ���õ�)
		
		
		// �׳� bean�� ����� ������ ������ �Ͼ �� ����.
		// 		
		
		/*
		 * ���� ������ ������ ���Թ��
		Tire tire = new HankookTire();
		Car car = new Car(tire);
		*/	

		car.prnTireBrand();		
	
	}
}
