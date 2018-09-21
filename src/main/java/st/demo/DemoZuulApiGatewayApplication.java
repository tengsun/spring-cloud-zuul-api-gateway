package st.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class DemoZuulApiGatewayApplication {
	
	@Bean
	public DemoAccessFilter accessFilter() {
		return new DemoAccessFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoZuulApiGatewayApplication.class, args);
	}
}
