package di.anno.n02;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/*
 * Ÿ�̾ �����ؼ� �޸� �� �ֵ��� �� ���̴�.
 * �׷��� Ÿ�̾��� �귣�尡 ���� �ٸ��Ƿ�, �귣���� ������ ������������ �Ѵ�.
 */

public class Car {

	@Autowired(required = false)
	@Qualifier("kumho")
	private Tire tire; // �������� �߻�

	public Car() {
		System.out.println("Car() ȣ�� . . .");
	}

	// ������ ����
	@Autowired
	public Car(@Qualifier("kumho") Tire tire) {
		// �Ķ���Ϳ� @Qualifier�� ���� ����? --> �Ķ���Ϳ� Tire tire, Tire tire2 �̷��� �ΰ� �̻��� ���� ���
		// ù ��°�� hankook, �� ��°�� kumho�� ���� �ִ�. �Ķ���ͳ��� �ε����� ��츦 �����ϱ� ���ؼ� ���ش�.
		this.tire = tire;
		System.out.println("Car(tire) ȣ�� . . .");
	}

	// �Ӽ�����(Setter ����)
	@Autowired
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire(Tire) ȣ�� . . .");
	}

	public void prnTireBrand() {
		System.out.println("������ Ÿ�̾� : " + tire.getBrand());
	}

}