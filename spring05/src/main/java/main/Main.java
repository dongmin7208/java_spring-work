package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring05.Client;
import spring05.Client2;

public class Main {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:springConf.xml");
		Client2 client = ctx.getBean("client2", Client2.class);
		client.send();
		ctx.close();
	}
}