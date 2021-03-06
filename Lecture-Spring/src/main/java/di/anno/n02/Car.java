package di.anno.n02;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/*
 * 타이어를 장착해서 달릴 수 있도록 할 것이다.
 * 그런데 타이어의 브랜드가 각기 다르므로, 브랜드의 정보를 가지고오려고 한다.
 */

public class Car {

	@Autowired(required = false)
	@Qualifier("kumho")
	private Tire tire; // 의존관계 발생

	public Car() {
		System.out.println("Car() 호출 . . .");
	}

	// 생성자 주입
	@Autowired
	public Car(@Qualifier("kumho") Tire tire) {
		// 파라미터에 @Qualifier를 쓰는 이유? --> 파라미터에 Tire tire, Tire tire2 이렇게 두개 이상이 오는 경우
		// 첫 번째는 hankook, 두 번째는 kumho일 수도 있다. 파라미터끼리 부딪히는 경우를 방지하기 위해서 써준다.
		this.tire = tire;
		System.out.println("Car(tire) 호출 . . .");
	}

	// 속성주입(Setter 주입)
	@Autowired
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire(Tire) 호출 . . .");
	}

	public void prnTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}

}
