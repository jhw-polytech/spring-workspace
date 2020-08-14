package di.test03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // 만약 "myCal"이라는 id로 getBean해서 불러오려면 @Component("myCal") 이라고 표기
public class MyCalculator { // 클래스 이름을 따라 자동으로 id가 myCalculator로 설정됨

//	@Value("10")
	private int firstNum;
//	@Value("4")
	private int secondNum;
	
	@Autowired
	private Calculator calculator;
		
	public MyCalculator() {
	}
	
	public MyCalculator(Calculator calculator) {
		super();
		this.calculator = calculator;
	}

	@Autowired
	public MyCalculator(@Value("12")int firstNum, @Value("5")int secondNum, Calculator calculator) {
		super();
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		this.calculator = calculator;
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	public void add() {
		calculator.addition(firstNum, secondNum);
	}
	
	public void sub() {
		calculator.substration(firstNum, secondNum);
	}
	
	public void mul() {
		calculator.multiplication(firstNum, secondNum);
	}
	
	public void div() {
		calculator.division(firstNum, secondNum);
	}
}
