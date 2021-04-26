package com.hello.hellospring;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hello.hellospring.repository.JdbcMemberRepository;
import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.repository.MemoryMemberRepository;
import com.hello.hellospring.service.MemberService;

/*
 * Spring이 실행되면 @Configuration을 읽고, 그 안에 @Bean들을 Spring에 등록 
 */
@Configuration
public class SpringConfig {

	private final DataSource dataSource;

	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		// Spring DI를 사용하면 기존 코드를 손대지 않고, 설정만으로 구현 클래스를 변경할 수 있음
//		return new MemoryMemberRepository();
		return new JdbcMemberRepository(dataSource);
	}
}