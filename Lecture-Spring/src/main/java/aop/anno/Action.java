package aop.anno;
/*
 * ������ �ڵ常 ������ �ִ� ���Ŭ����
 */

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Action {
	
	@Before("execution(* work())")
	public static void gotoOffice() {
		System.out.println("����մϴ� . . .");
	}
	
	@After("execution(* aop.anno.*.work()")
	public static void getoffOffice() {
		System.out.println("����մϴ� . . .");
	}

}