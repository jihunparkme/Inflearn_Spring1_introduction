package com.hello.hellospring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.hellospring.domain.Member;
																	// Type, ID
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
	
	/**
	 * Spring Data JPA가 JpaRepository Interface를 상속받고 있으면 구현체를 자동으로 만들어준다.
	 * 그리고 Spring Bean에 자동으로 등록해준다.
	 */
	
	// JPQL select m from Member m where m.name = ?
	@Override
	Optional<Member> findByName(String name);
	
}
