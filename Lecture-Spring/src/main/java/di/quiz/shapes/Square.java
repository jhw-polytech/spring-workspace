package di.quiz.shapes;

import org.springframework.stereotype.Component;

@Component
public class Square implements Shape {

	@Override
	public void getArea(int width, int height) {
		System.out.println("���簢���� ���� : " + ( width * height));
	}

}
