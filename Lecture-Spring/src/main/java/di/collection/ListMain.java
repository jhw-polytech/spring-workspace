package di.collection;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ListMain {
	
	public static void main(String[] args) {
		
		/*
		 * ==> ���� ���
		List<String> address = new ArrayList<String>();
		
		address.add("����");
		address.add("�λ�");
		address.add("��õ");
				
//		ListAddress list = new ListAddress(address);		
		ListAddress list = new ListAddress();
		list.setAddress(address);
		*/
		
		
		ApplicationContext container = new GenericXmlApplicationContext("di-collection01.xml");
		
//		ListAddress list =  container.getBean("list", ListAddress.class);
//		ListAddress list =  container.getBean("list02", ListAddress.class);
		ListAddress list =  container.getBean("list03", ListAddress.class);
		
		for(String addr : list.getAddress()) {
			System.out.println(addr);
		}
		
		for(int number : list.getNumbers()) {
			System.out.println(number);
		}

		
	}

}
