package com.study.demo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class HelloLombok {
	@Getter
	private String hello;
	@Getter
	private int lombok;
	
	public static void main(String[] args) {
		//HelloLombok helloLombok = new HelloLombok("hello", 10);
		
		//helloLombok.setHello("dafaa");
		//helloLombok.setLombok(10);
		/*
		 * System.out.println(helloLombok.getHello());
		 * System.out.println(helloLombok.getLombok());
		 */
	}
}
