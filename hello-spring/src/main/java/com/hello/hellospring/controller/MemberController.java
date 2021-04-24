package com.hello.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hello.hellospring.service.MemberService;

/*
 * Spring이 실행되면서 Spring Container가 생기는데, 
 * 그 Container에 @Controller annotation이 있다면, 객체를 생성하여 Spring에 넣어 두고 관리한다.  
 * 
 * Spring Container에서 Spring Bean이 관리된다고 표현.
 * 
 * Controller를 통해 외부 요청을 받고, Service에서 Businesses Logic을 만들고, Repository에서 데이터를 저장
 */
@Controller
public class MemberController {
	
	private final MemberService memberService;

	/* DI (Depedency Injection) : 의존 관계를 주입!
	 * Member Controller가 생성이 될 때 
	 * Spring Bean에 등록되어 있는 memberService 객체를 사용 
	 */
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
}