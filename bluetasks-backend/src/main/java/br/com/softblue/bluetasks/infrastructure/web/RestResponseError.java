package br.com.softblue.bluetasks.infrastructure.web;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class RestResponseError {

	private String error;
	
	private RestResponseError() {

	}

	public String getError() {
		return error;
	}
	
	public static RestResponseError fromValidationError(Errors errors) {
		RestResponseError restResponseError = new RestResponseError();
		StringBuilder sb = new StringBuilder();
		
		for(ObjectError error : errors.getAllErrors()) {
			sb.append(error.getDefaultMessage() + " .");
		}
		restResponseError.error = sb.toString();
		return restResponseError;
	}
	
	public static RestResponseError fromMessage(String message) {
		RestResponseError resp = new RestResponseError();
		resp.error = message;
		return resp;
	}
}
