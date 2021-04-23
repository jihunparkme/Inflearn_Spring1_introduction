package com.hello.hellospring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.hello.hellospring.domain.Member;

class MemoryMemberRepositoryTest {
	MemoryMemberRepository repository = new MemoryMemberRepository();

	@AfterEach
	// 메서드 실행이 끝날 때마다 동작
	// 테스트는 서로 의존관계 없이 동작해야 한다!
	public void afterEach() {
		repository.clearStore();
	}

	@Test
	public void save() {
		// given
		Member member = new Member();
		member.setName("spring"); // when
		repository.save(member);
		// then
		Member result = repository.findById(member.getId()).get();
		assertThat(result).isEqualTo(member);
	}

	@Test
	public void findByName() {
		// given
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		// when
		Member result = repository.findByName("spring1").get();
		// then
		assertThat(result).isEqualTo(member1);
	}

	@Test
	public void findAll() {
		// given
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		// when
		List<Member> result = repository.findAll(); // then
		assertThat(result.size()).isEqualTo(2);
	}
}