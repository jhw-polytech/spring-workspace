package di.anno.n01;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

/*
 * Ÿ�̾ �����ؼ� �޸� �� �ֵ��� �� ���̴�.
 * �׷��� Ÿ�̾��� �귣�尡 ���� �ٸ��Ƿ�, �귣���� ������ ������������ �Ѵ�.
 */

public class Car {
	
//	@Autowired
	@Resource
	private Tire tire; //�������� �߻�
	
	public Car() {
		System.out.println("Car() ȣ�� . . .");
	}
	
	// ������ ����
//	@Autowired
	public Car(Tire tire) {
		this.tire = tire;		
		System.out.println("Car(tire) ȣ�� . . .");
	}
	
	
	// �Ӽ�����(Setter ����)
//	@Autowired
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire(Tire) ȣ�� . . .");
	}
	
	/*
	 * public void prnTireBrand() { System.out.println("������ Ÿ�̾� : " +
	 * tire.getBrand()); }
	 */
	
	
}