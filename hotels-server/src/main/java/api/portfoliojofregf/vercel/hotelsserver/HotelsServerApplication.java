package api.portfoliojofregf.vercel.hotelsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelsServerApplication.class, args);
	}

}
