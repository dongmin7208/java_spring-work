package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import conf.JavaConfigPrototype;
import spring05.Client;
import spring05.Client2;

public class MainPrototype2 {
	public static void main(String[] args) {
		useXml();
		useJava();
	}
	
	private static void useXml() {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:springConfPrototype.xml");
		Client client1 = ctx.getBean("client", Client.class);
		Client client2 = ctx.getBean("client", Client.class);
		
		System.out.println(client1 + " " + client2);
		System.out.println(
		"xml 설정 prototype: (client1 != client2) -> " + (client1 != client2));
		
		ctx.close();
		try {
			client1.destroy();
			client2.destroy();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void useJava() {
		AbstractApplicationContext ctx =
				new AnnotationConfigApplicationContext(JavaConfigPrototype.class);
		Client2 client1 = ctx.getBean("client2", Client2.class);
		Client2 client2 = ctx.getBean("client2", Client2.class);
		
		System.out.println(client1 + " " + client2);
		System.out.println(
		"java 설정 prototype: (client1 != client2) -> " + (client1 != client2));
		
		ctx.close();
		try {
			client1.close();
			client2.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}