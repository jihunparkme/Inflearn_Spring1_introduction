package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import com.example.demo.domain.Member;

public interface MemberRepository {
	Member save(Member member);
	Optional<Member> findById(Long id); // null 방지를 위해 Optional 사용
	Optional<Member> findByName(String name);
	List<Member> findAll();
}