package com.hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * Spring이 실행되면서 Spring Container가 생기는데, 
 * @Controller annotation이 있다면 객체를 생성하여 Spring에 넣어 두고 관리
 * Spring Container에서 Spring Bean이 관리된다고 표현.
 * 
 * Controller를 통해 외부 요청을 받고, Service에서 Businesses Logic을 만들고, Repository에서 데이터를 저장
 */
@Controller
public class HelloController {

	/*
	 * Controller에서 매핑되는 URL이은 welcome page(static/index.html)보다 높은 우선순위를 갖음.
	 *
	 * 컨트롤러에서 리턴 값으로 문자를 반환하면 viewResolver가 화면을 찾아서 처리
	 * Spring Boot 템플릿 엔진은 기본으로 viewName 매핑 (resources:templates/{ViewName}.html)
	 */
	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data", "hello!!");
		return "hello";
	}

	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello-template";
	}

	/*
	 * @ResponseBody를 사용하면 viewResolver를 사용하지 않음
	 * 객체를 반환하면 객체가 JSON으로 변환 (HttpMessageConverter 동작)
	 */
	@GetMapping("hello-string")
	@ResponseBody
	public String helloString(@RequestParam("name") String name) {
		return "hello " + name;
	}

	@GetMapping("hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam("name") String name) {
		Hello hello = new Hello();
		hello.setName(name);
		return hello;
	}

	static class Hello {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}