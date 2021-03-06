package com.hello.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hello.hellospring.aop.TimeTraceAop;
import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.service.MemberService;

/*
 * Spring이 실행되면 @Configuration을 읽고, 그 안에 @Bean들을 Spring에 등록 
 */
@Configuration
public class SpringConfig {

	private final MemberRepository memberRepository;
	
	/*
	 *  @Autowired가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다
	 */
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
	
	@Bean
	public TimeTraceAop timeTraceAop() { // 직접 Bean으로 등록하면서 아~ AOP가 쓰이는구나를 인지
		return new TimeTraceAop();
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