package spring01;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

//public class Main {
//	public static void main(String[] args) {
//		GenericXmlApplicationContext ctx =
//				new GenericXmlApplicationContext("classpath:applicationContext.xml");
//		
//		Greeter greet = ctx.getBean("greeter", Greeter.class);
//		System.out.println(greet.greet("박동민"));
//		ctx.close();
//	}
//}

public class Main{
	public static void main(String[] args) throws Throwable {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Scanner sc = new Scanner(System.in);
		
		Calculator calc = ctx.getBean("calculator", Calculator.class);
		//야 ctx 가져와 calculator쓸꺼야
		System.out.println("첫번째 수 :");
		int val1 = Integer.parseInt(sc.nextLine());
		System.out.println("두번째 수 :");
		int val2 = Integer.parseInt(sc.nextLine());
		System.out.println("+ , - , *, / ");
		char op = (char)System.in.read();
		int ret = 0;
		switch (op) {
		case '+': ret=calc.add(val1, val2);break;
		case '-': ret=calc.sub(val1, val2);break;
		case '*': ret=calc.mul(val1, val2);break;
		case '/': ret=calc.div(val1, val2);break;
		}
		System.out.println("=" + ret);
		
	}
}