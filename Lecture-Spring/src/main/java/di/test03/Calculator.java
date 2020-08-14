package di.test03;

import org.springframework.stereotype.Service;

@Service //@Component¶ó°í ºÙ¿©µµ µÊ
public class Calculator {
	
	public void addition(int firstNum, int secondNum) {
		System.out.printf("µ¡¼À°á°ú : %d + %d = %d\n", firstNum, secondNum, (firstNum + secondNum));
	}
	
	public void substration(int firstNum, int secondNum) {
		System.out.printf("»¬¼À°á°ú : %d - %d = %d\n", firstNum, secondNum, (firstNum - secondNum));
	}
	
	public void multiplication(int firstNum, int secondNum) {
		System.out.printf("°ö¼À°á°ú : %d * %d = %d\n", firstNum, secondNum, (firstNum * secondNum));
	}
	
	public void division(int firstNum, int secondNum) {
		System.out.printf("³ª´°¼À°á°ú : %d - %d = %.2f\n", firstNum, secondNum, ((double)firstNum / secondNum));
	}

}
