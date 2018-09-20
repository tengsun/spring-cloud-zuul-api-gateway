package st.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class DemoZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoZuulApiGatewayApplication.class, args);
	}
}
