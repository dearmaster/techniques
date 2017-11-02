package com.master.techniques.aop.spring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "com.master.techniques.aop.spring.annotation" })
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SimpleConfiguration {
}