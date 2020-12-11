package com.kapila.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.kapila.demo.client.util.FeignErrorDecoderClassService;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class EnrollmentManagementKapilaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnrollmentManagementKapilaApplication.class, args);
	}

	/*
	 * @Bean public FeignErrorDecoderClassService errorDecoder() { return new
	 * FeignErrorDecoderClassService(); }
	 */

	/*
	 * @Bean public Customizer<Resilience4JCircuitBreakerFactory>
	 * defaultCustomizer() { return factory -> factory.configureDefault(id -> new
	 * Resilience4JConfigBuilder(id)
	 * .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.
	 * ofSeconds(3)).build())
	 * .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults()) .build()); }
	 */

}
