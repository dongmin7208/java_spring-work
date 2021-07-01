package aop003;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

public class MyAspect {
	//아무녀석과도 관계가없는녀석 POJO 포조라고 그래요
	public void before(JoinPoint jp) {
		System.out.println("얼굴 인식: 문을 개방한다.");
	}

}
