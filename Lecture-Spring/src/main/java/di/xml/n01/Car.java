package di.xml.n01;

/*
 * 타이어를 장착해서 달릴 수 있도록 할 것이다.
 * 그런데 타이어의 브랜드가 각기 다르므로, 브랜드의 정보를 가지고오려고 한다.
 */

public class Car {
	
	private Tire tire;

	// 속성주입(setter injection)
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	public void prnTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
	
}
