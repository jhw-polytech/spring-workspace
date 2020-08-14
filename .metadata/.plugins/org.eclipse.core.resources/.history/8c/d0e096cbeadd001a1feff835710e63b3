package di.test01;

public class MyCalculator {


	private int firstNum;
	private int secondNum;
	private Calculator calculator;
		
	public MyCalculator() {
	}
	
	public MyCalculator(Calculator calculator) {
		super();
		this.calculator = calculator;
	}

	public MyCalculator(int firstNum, int secondNum, Calculator calculator) {
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
