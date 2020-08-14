package di.quiz.shapes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author HP
 *
 */
@Component
public class Area {

	@Autowired
	@Qualifier("circle")
	Shape shape; // 의존관계 발생
	
	@Value("5")
	int width;
	@Value("7")
	int height;

	public Area() {

	}

	public Area(Shape shape) {
		super();
		this.shape = shape;
	}

	public Area(Shape shape, int width, int height) {
		super();
		this.shape = shape;
		this.width = width;
		this.height = height;
	}
	
	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void prnArea() {
		shape.getArea(width, height);
	}


}
