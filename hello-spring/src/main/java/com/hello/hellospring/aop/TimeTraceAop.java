package com.hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @Aspect : AOP임을 명시, 핵심 관심사항(추가, 조회 등)과 공통 관심 사항(시간 측정)을 분리
 * @Component : ComponentScan으로 Spring Bean 등록을 할 수 있지만 직접 등록해서 사용하는 것을 선호
 * 				AOP는 특별하니까!
 */
@Aspect
public class TimeTraceAop {
	
	@Around("execution(* hello.hellospring..*(..))") // AOP 적용 범위
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
		System.out.println("START: " + joinPoint.toString()); // 어떤 메서드가 Call 되었는지
		
		try {
			return joinPoint.proceed(); // 다음 메서드로 진행
		} finally {
			long finish = System.currentTimeMillis();
			long timeMs = finish - start;
			System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
		}
	}
}