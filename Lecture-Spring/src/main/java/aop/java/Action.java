package aop.java;
/*
 * ������ �ڵ常 ������ �ִ� ���Ŭ����
 */

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class Action {
	
	@Before("execution(* work())")
	public static void gotoOffice() {
		System.out.println("����մϴ� . . .");
	}
	
	@After("execution(* aop.java.*.work())")
	public static void getoffOffice() {
		System.out.println("����մϴ� . . .");
	}

}