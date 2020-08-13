package di.basic;

/*
 * 타이어를 장착해서 달릴 수 있도록 할 것이다.
 * 그런데 타이어의 브랜드가 각기 다르므로, 브랜드의 정보를 가지고오려고 한다.
 */

public class Car {
	
	/* 1. 의존관계 발생 */
	private Tire tire;
	
	/* 2. 장착된 타이어를 갖고오기만 하면 된다. */
	
	public Car() { }
	
	// Composition (생성자 안에서 new를 찍어줌)
	//public Car() {
		// 의존관계 설정
		// tire = new HankookTire(); // 사용자가 자동차를 주문했을 때 타이어가 장착된다.
		// tire = new KumhoTire(); // 한국타이어가 아닌 금호타이어가 부착됐지만, 사용자는 알 수 없다.
	//}	
	
	// Aggregation (매개변수로 객체를 받아옴)
	// 생성자 주입(Constructor injection) --- 의존성을 낮춘다?
	public Car(Tire tire) { // 차 주문할 때부터 타이어가 함께 나옴. Tire 객체를 초기셋팅값이 정해져있다(내가 정한다)
		this.tire = tire;		
	}
	
	// 속성주입(Setter injection) --- 원하는 타이어를 선택해서 넣는다
	// Car 클래스는 Tire 클래스에 대해 의존관계를 갖고있지만, Tire가 바뀌더라도 코드를 고칠 필요 없이 가져오기만 하면 된다.
	// 단일 체계 원칙: 책임질 라인을 1명만 하도록 하는 것(변화에 덜 민감)
	public void setTire(Tire tire) { // 생성을 먼저 하고 setter를 통해서 타이어를 껴줌
		this.tire = tire;
	}
	
	public void prnTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
	
}
