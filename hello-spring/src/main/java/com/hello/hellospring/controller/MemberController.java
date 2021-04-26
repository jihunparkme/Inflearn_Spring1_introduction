package com.hello.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hello.hellospring.domain.Member;
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

	// 1. DI 필드 주입
	/*
	 * 단점 : Spring이 가동될 때를 제외하고 바꿀 수 있는 방법이 없어서 안 좋음!!
	 */
//	 @Autowired private MemberService memberService;

	// 2. DI 생성자 주입 (요즘 추천하는 방법)
	/*
	 * Spring 조립 시 설정해두고 의존관계가 더이상 바꿀 수 없도록 설정
	 */
	/*
	 * DI (Depedency Injection) : 의존 관계를 주입! Member Controller가 생성이 될 때 Spring Bean에
	 * 등록되어 있는 memberService 객체를 사용
	 */
	private final MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	// 3. DI Setter 주입
	/*
	 * 단점 : Spring 조립 후 중간에 setter를 호출할 일이 없는데, pubilc 메서드로 노출되어서 좋지 않음!!
	 */
//	private MemberService memberService;
//	
//	@Autowired
//	public void setMemberService(MemberService memberService) {
//		this.memberService = memberService;
//	}

	@GetMapping(value = "/members/new")
	public String createForm() {
		// String으로 return되면 templates에서 아래 경로의 파일을 찾는다.
		return "members/createMemberForm";
	}

	@PostMapping(value = "/members/new")
	public String create(MemberForm form) {
		Member member = new Member();
		member.setName(form.getName());

		memberService.join(member);
		
		return "redirect:/";
	}
}