package di.java;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * 기존에 xml이 하던 객체생성을 자바 파일이 하게 하기 위한 클래스
 * (<context:component-scan base-package="di.test03" />를 대체)
 */

@ComponentScan(basePackages={"di.java"})
@Configuration
public class Config {

	/*
//	@Bean(name = "car")
//	public Car getCar() { // 여기 있는 이름이 저기 있는 id가 된다..? 메소드 이름을 car()라고 하면 
	@Bean
	public Car car() {
		return new Car();
	}
	
	@Bean(name="kumho")
	public Tire kumhoTire() {
		return new KumhoTire();
	}

//	public Tire getTire() {
// getTire라는 이름은 중요하지 않음! HankookTire 객체를 컨테이너에 올린다는 게 중요! 그러나 편의상 클래스이름과 메소드명을 일치시키도록 하자
	@Bean
	@Qualifier("hankook")
	public Tire hankookTire() {
		return new HankookTire();
		// <bean class="di.java.HankookTire" id="hankookTire" />
	}
*/
	
	
}
