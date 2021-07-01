package aop005;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	
	@Before("execution(* runSomething())")
	public void before(JoinPoint joinPoint) {
		System.out.println("얼굴 인식 확인 : 문을 개방한다.");
	}

	@After("execution(* runSomething())")
	public void lockDoor(JoinPoint joinPoint) {
		System.out.println("주인이 나감 : 문을 잠궈라");
	}
}
