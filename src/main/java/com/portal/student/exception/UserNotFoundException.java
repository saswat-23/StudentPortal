package com.portal.student.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserNotFoundException extends RuntimeException {
	
	Logger logger = LoggerFactory.getLogger(UserNotFoundException.class);
	
	private static final long serialVersionUID = 1L;

}
