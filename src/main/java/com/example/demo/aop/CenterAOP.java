package com.example.demo.aop;

import java.util.List;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dto.ProductDTO;
import com.example.demo.product.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Configuration
public class CenterAOP {

//	Logger log = LoggerFactory.getLogger(getClass());

//	@Pointcut("execution(* packages.class.method(..)&)")
//	@Pointcut("execution(* public * getAll(..))")
//	public void pointCuts() {
//
//	}

//	@Before("execution(* com.dao.*.*(..)) && args(lo)")
//	@Before("execution(* com.example.demo.product.*.*(..))") // execute in all cases before
//	public void before() {
//		log.info(getClass().toString());
//		log.warn("Before");
//	}
//
//	@After("execution(* com.example.demo.product.*.*(..))") // execute in all cases after
//	public void after() {
//		log.warn("After");
//	}
//
//	@AfterReturning("execution(* com.example.demo.product.*.*(..))") // // execute when flow not has any obstacles
//	public void afterReturn() throws Throwable {
//		log.warn("AfterReturning");
//	}
//
//	@AfterThrowing("execution(* com.example.demo.product.*.*(..))") // // execute when flow any obstacles
//	public void afterthrow() {
//		log.warn("afterThrowing");
//	}
//
//	@Around("execution(* com.example.demo.product.*.*(..))") // // execute when flow not has any obstacles
//	public void around(ProceedingJoinPoint pjp ) throws Throwable {
//		log.warn("around");
//		pjp.proceed();
//	}
//	  

 	@AfterReturning(pointcut = "execution(* com.example.demo.product.*.*(..))", returning = "result")
	public void getReturnResul(JoinPoint joinPoint, Object result) {
		Product temp;
		if (result instanceof Product) {
			temp = (Product) result;
			temp.setName(temp.getArName() != null ? temp.getArName() : temp.getEnName());
		} else if (result instanceof List) {
			if (((List<?>) result).get(0) instanceof Product) {
				((List<Product>) result).forEach(product -> {
					product.setName(product.getArName() != null ? product.getArName() : product.getEnName());
				});
			}
		}
	}

}
