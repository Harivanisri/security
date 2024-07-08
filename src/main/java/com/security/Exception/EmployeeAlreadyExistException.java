package com.security.Exception;

public class EmployeeAlreadyExistException extends RuntimeException{

	public EmployeeAlreadyExistException(String str) {
		super(str);
	}
}
