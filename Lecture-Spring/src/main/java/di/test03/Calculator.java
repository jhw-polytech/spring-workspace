package di.test03;

import org.springframework.stereotype.Service;

@Service //@Component��� �ٿ��� ��
public class Calculator {
	
	public void addition(int firstNum, int secondNum) {
		System.out.printf("������� : %d + %d = %d\n", firstNum, secondNum, (firstNum + secondNum));
	}
	
	public void substration(int firstNum, int secondNum) {
		System.out.printf("������� : %d - %d = %d\n", firstNum, secondNum, (firstNum - secondNum));
	}
	
	public void multiplication(int firstNum, int secondNum) {
		System.out.printf("������� : %d * %d = %d\n", firstNum, secondNum, (firstNum * secondNum));
	}
	
	public void division(int firstNum, int secondNum) {
		System.out.printf("��������� : %d - %d = %.2f\n", firstNum, secondNum, ((double)firstNum / secondNum));
	}

}
