package com.mastercard.paymenttransfersystem;

import com.mastercard.paymenttransfersystem.security.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class PaymentTransferApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PaymentTransferApplication.class, args);
	}
}
