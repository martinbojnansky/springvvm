package com.bojnansky.springvvm.simple;

import com.bojnansky.springvvm.framework.Model;

public class SimpleModel implements Model {
	private String name;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGreeting() {
		return "Hello, " +  this.name;
	}
}
