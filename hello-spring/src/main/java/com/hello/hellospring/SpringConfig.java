package com.hello.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.repository.MemoryMemberRepository;
import com.hello.hellospring.service.MemberService;

/*
 * Spring이 실행되면 @Configuration을 읽고, 그 안에 @Bean들을 Spring에 등록 
 */
@Configuration
public class SpringConfig {
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
}