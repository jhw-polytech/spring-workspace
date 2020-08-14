package di.java;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * ������ xml�� �ϴ� ��ü������ �ڹ� ������ �ϰ� �ϱ� ���� Ŭ����
 * (<context:component-scan base-package="di.test03" />�� ��ü)
 */

@ComponentScan(basePackages={"di.java"})
@Configuration
public class Config {

	/*
//	@Bean(name = "car")
//	public Car getCar() { // ���� �ִ� �̸��� ���� �ִ� id�� �ȴ�..? �޼ҵ� �̸��� car()��� �ϸ� 
	@Bean
	public Car car() {
		return new Car();
	}
	
	@Bean(name="kumho")
	public Tire kumhoTire() {
		return new KumhoTire();
	}

//	public Tire getTire() {
// getTire��� �̸��� �߿����� ����! HankookTire ��ü�� �����̳ʿ� �ø��ٴ� �� �߿�! �׷��� ���ǻ� Ŭ�����̸��� �޼ҵ���� ��ġ��Ű���� ����
	@Bean
	@Qualifier("hankook")
	public Tire hankookTire() {
		return new HankookTire();
		// <bean class="di.java.HankookTire" id="hankookTire" />
	}
*/
	
	
}