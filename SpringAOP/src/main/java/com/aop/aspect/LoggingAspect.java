package com.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.aop.model.User;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

	@Before("execution(* com.aop.service.UserService.save(..))")
	public void beforeSaveUserLog() {
		log.info("Enter into save User method");
	}
	
	@After("execution(* com.aop.service.UserService.save(..))")
	public void afterSaveUserLog() {
		log.info("Returing from save user method");
	}
	@Around("execution( * com.aop.service.UserService.getUser(..))")
	public User beforeGetUserLog(ProceedingJoinPoint joinpoint) throws Throwable {
		log.info("enterd get user method");
		
		Object result = joinpoint.proceed(); 
		
		log.info("Returing from save user method");
		return (User)result;
	}
	
	@Around("execution( * com.aop.service.UserService.*(..))")
	public Object logEntryAndExit(ProceedingJoinPoint joinpoint) throws Throwable {
		log.info("Entered method :{}",joinpoint.getSignature().getName());
		
		Object result = joinpoint.proceed();
		log.info("Returned from method");
		return result;
	}
	
	@AfterThrowing("executation(* com.aop.service.UserService.getUser(..))")
	public void userNotFoundLog() {
		log.error("User Id Not Found");
	}
	
	@AfterReturning("executation(* com.aop.service.UserService.getUser(..))")
	public void getUserExit() {
		log.info("Returning   from getUser methods");
	}
}
