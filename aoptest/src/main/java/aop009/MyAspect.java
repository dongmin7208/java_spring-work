package aop009;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	public void before(JoinPoint joinPoint) {
		System.out.println("얼굴 인식 확인 : 문을 개방 한다.");
	}
	public void lockDoor(JoinPoint joinPoint) {
		System.out.println("주인이 나감 : 문을 잠궈라");
	}
	
	public void around(ProceedingJoinPoint joinPoint) {
		System.out.println("밥을 먹는다.");
		try {
			joinPoint.proceed();
		}catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("씻는다.");
	}
	
	public void afterReturning(JoinPoint joinPoint) {
		System.out.println("게임 종료");
	}
}
