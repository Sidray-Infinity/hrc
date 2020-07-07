package com.javabasics.question3;

public class ZeroNumberException extends RuntimeException {
	private static final long serialVersionUID = 7718828512143293558L;
	
	@Override
	public String toString() {
		return "n or p should not be zero";
	}
	
}
