package di.java;

import org.springframework.stereotype.Component;

@Component("hankook") // ���� �ڵ������� id�� "hankookTire"��� �����Ǵµ�, ������̼� �ȿ� id�� ������ָ� ��õ� id�� �����ȴ�.
public class HankookTire implements Tire {
	
	public HankookTire() {
		System.out.println("�ѱ�Ÿ�̾� ������ ȣ�� . . .");
	}
	
	public String getBrand() {
		return "�ѱ�Ÿ�̾�";
	}

}
