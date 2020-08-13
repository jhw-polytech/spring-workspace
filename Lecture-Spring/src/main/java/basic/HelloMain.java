package basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		
		// ApplicationContext context = new ClassPathXmlApplicationContext("beanContainer.xml");
		// ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/beanContainer.xml");
		// Class Path�� ���� ���ؼ� src/main/resources ���� �ݵ�� ����� �Ѵ�.
		ApplicationContext context = new GenericXmlApplicationContext("classpath:beanContainer.xml"); // ("beanContainer.xml"); �̷��Ը� ��� �ȴ�			
		
		// �׳� ��ü ����
		Hello obj = (Hello)context.getBean("hello");
		obj.prnMsg();
		
		Hello obj2 = (Hello)context.getBean("hello2");
		obj2.prnMsg();
		
		System.out.println(obj);
		System.out.println(obj2); // obj, obj2�� �ּҰ��� ���� �ٸ���(���� �ٸ� ��ü)

		
		// �̱���
		HelloSingle obj3 = (HelloSingle)context.getBean("hs");
		// HelloSingle obj3 = context.getBean("hs", HelloSingle.class); �� ���� �������� ���� ������ ����ȯ ���� ��� ����
		HelloSingle obj4 = (HelloSingle)context.getBean("hs2");
		obj3.prnMsg();
		System.out.println(obj3);
		System.out.println(obj4); // obj3, obj4�� �ּҰ��� �Ȱ��� ������ ���� Ȯ���� �� �ִ�.
		
		
	}
}