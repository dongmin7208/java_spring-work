package conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring05.Client;
import spring05.Client2;

@Configuration
public class JavaConfig {
	
	@Bean
	public Client client() {
		Client client = new Client();
		client.setHost("서버");
		return client;
	}
	
	@Bean	//initMethod 생략 가능
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("서버2");
		return client2;
	}
}
