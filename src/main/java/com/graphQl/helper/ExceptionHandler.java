package com.graphQl.helper;

public class ExceptionHandler {
	
	public static RuntimeException throwResourceNotFoundExcpetion()
	{
		return new RuntimeException("Resource Not Found !!!");
		
	}

}
