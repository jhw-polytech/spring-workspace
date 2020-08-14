package di.java;

import org.springframework.stereotype.Component;

@Component("hankook") // 원래 자동적으로 id가 "hankookTire"라고 생성되는데, 어노테이션 안에 id를 명시해주면 명시된 id로 생성된다.
public class HankookTire implements Tire {
	
	public HankookTire() {
		System.out.println("한국타이어 생성자 호출 . . .");
	}
	
	public String getBrand() {
		return "한국타이어";
	}

}
