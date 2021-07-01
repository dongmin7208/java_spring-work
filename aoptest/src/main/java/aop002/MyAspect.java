package aop002;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//어느 특정(관점)에 사용될꺼야~ 어노테이션 주입식
@Aspect   
public class MyAspect {
	
	//어느 시점에 동작해야되 라고 비포  그런데 뭐 전에 동작할껀데?  
	//그 어떤것을 비포 뒤에 해야됨 ///public void aop002.Boy.runSomething()//// 1.aSPECT설정이야 2.BEFORE  3.밑에 포인트컷 위치 지정
	@Before("execution(public void aop002.Boy.runSomething()) ||"
			+ "execution(public void aop002.Girl.runSomething())")
	public void before(JoinPoint jp) {
		System.out.println("얼굴 인식: 문을 개방한다.");
	}

}
