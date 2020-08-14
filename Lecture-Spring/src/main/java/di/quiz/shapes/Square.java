package di.quiz.shapes;

import org.springframework.stereotype.Component;

@Component
public class Square implements Shape {

	@Override
	public void getArea(int width, int height) {
		System.out.println("정사각형의 넓이 : " + ( width * height));
	}

}
