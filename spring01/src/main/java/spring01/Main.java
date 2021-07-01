package spring01;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Greeter greet = ctx.getBean("greeter", Greeter.class);
		System.out.println(greet.greet("나루토"));
		
		System.out.print("첫 번째 수 입력 : ");
		int n1 = Integer.parseInt(sc.nextLine());
		System.out.print("부호 입력 : ");
		char op = sc.nextLine().charAt(0);
		System.out.print("두 번째 수 입력 : ");
		int n2 = Integer.parseInt(sc.nextLine());
		
		Calculator calc = ctx.getBean("calc", Calculator.class);
		// 객체생성 및 관리를 스프링에게 넘김
		System.out.println(calc.calcResult(n1, n2, op));
		ctx.close();
		
		// spring 객체를 보관하는 컨테이너
	}
}