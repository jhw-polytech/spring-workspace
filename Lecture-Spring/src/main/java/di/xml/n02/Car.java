package di.xml.n02;

public class Car {
	
	private Tire tire;
	
	public Car() {
		System.out.println("Car() ������ ȣ�� . . .");
	}
	
	public Car(Tire tire) {
		System.out.println("Car(Tire) ������ ȣ�� . . .");
		this.tire = tire;		
	}
	
	
	public Car(Tire tire01, Tire tire02) {
		System.out.println("Car(Tire, Tire) ������ ȣ�� . . .");
		System.out.println(tire01.getBrand() + " : " + tire02.getBrand());
	}
	
	public Car(Tire tire, String msg) {
		System.out.println("Car(Tire, String) ������ ȣ�� . . .");
		System.out.println("msg : " + msg);
	}
	
	public void prnTireBrand() {
		System.out.println("������ Ÿ�̾� : " + tire.getBrand());
	}

}