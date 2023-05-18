package io.undefvar.momoopenapispringbootdemo;

import io.undefvar.momoopenapispringbootdemo.clients.MomoApiClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties
@SpringBootApplication
@EnableFeignClients
@RequiredArgsConstructor
@Slf4j
public class MomoOpenApiSpringbootDemoApplication {
	private final MomoApiClient momoApiClient;

	@Bean
	ApplicationRunner application(){
		return args -> {
			var response = momoApiClient.getAccountBalance();
			log.info("Acccount Balance from MomoApi: {}", response);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MomoOpenApiSpringbootDemoApplication.class, args);
	}

}
