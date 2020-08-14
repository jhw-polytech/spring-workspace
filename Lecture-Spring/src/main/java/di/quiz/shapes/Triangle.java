package di.quiz.shapes;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape {
	
	@Override
	public void getArea(int width, int height) {
		System.out.println("»ï°¢ÇüÀÇ ³ÐÀÌ : " + ( width * height * 0.5));
	}

}
