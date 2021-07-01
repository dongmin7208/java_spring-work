package aop004;

import org.aspectj.lang.JoinPoint;

public class MyAspect {
	public void before(JoinPoint joinPoint) {
		System.out.println("얼굴 인식 확인 : 문을 개방 한다.");
	}
	public void lockDoor(JoinPoint joinPoint) {
		System.out.println("주인이 나감 : 문을 잠궈라");
	}
}
