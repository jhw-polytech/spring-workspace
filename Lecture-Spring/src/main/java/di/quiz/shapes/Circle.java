package di.quiz.shapes;

import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape {
	
	@Override
	public void getArea(int width, int height) {
		System.out.println("¿øÀÇ ³ÐÀÌ : " + ( width * width * 3.14));
	}

}
