package com.hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication의 패키지 포함 하위 패키지를 모두 탐색(Component Scan)해서 Spring Bean으로 등록
 * 
 * 참고 : Spring Container에 Spring Bean으로 등록할 때, 기본으로 싱클톤 등록.
 * 유일하게 하나만 등록하여 공유하므로 같은 Spring Bean이면 모두 같은 인스턴스
 */
@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
