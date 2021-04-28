package com.hello.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.service.MemberService;

/*
 * Spring이 실행되면 @Configuration을 읽고, 그 안에 @Bean들을 Spring에 등록 
 */
@Configuration
public class SpringConfig {

	private final MemberRepository memberRepository;
	
	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		/**
		 * Spring Data JPA가 Spring Bean에 등록해놓은 객체를 가져다 쓰면 끝!
		 */
		this.memberRepository = memberRepository;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}

//	@Bean
//	public MemberRepository memberRepository() {
		// Spring DI를 사용하면 기존 코드를 손대지 않고, 설정만으로 구현 클래스를 변경할 수 있음
//		return new MemoryMemberRepository();
//		return new JdbcMemberRepository(dataSource);
//		return new JdbcTemplateMemberRepository(dataSource);
//		return new JpaMemberRepository(em);
//	}
}