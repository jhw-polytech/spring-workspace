package aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * Spring AOP 특징
 * 1. Runtime 기반
 * 2. Proxy 기반   ---------------> 핵심 메소드(work())가 실행되길 기다리고 있다가,
 * 3. Interface 기반
 */

public class EmpMain {
   
   public static void main(String[] args) {
      
      ApplicationContext context = new GenericXmlApplicationContext("aop-xml.xml");
      // Programmer programmer = (Programmer) context.getBean("programmer");
      // programmer.work();
      Employee e = (Employee) context.getBean("programmer"); // 인터페이스 기반이므로 인터페이스형으로 받아줘야 함
      e.work();
      
      e = context.getBean("designer", Employee.class);
      e.work();
      
      e = context.getBean("manager", Employee.class);
      e.work();
   }

}