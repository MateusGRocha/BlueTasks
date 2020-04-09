package br.com.softblue.bluetasks.infrastructure.web;

import org.springframework.data.rest.core.RepositoryConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.softblue.bluetasks.domain.task.DuplicatedTaskException;

@RestControllerAdvice
public class WebResquestExceptionHandler {

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public RestResponseError handleException(RepositoryConstraintViolationException e) {
		return RestResponseError.fromValidationError(e.getErrors());
	}
		
		@ExceptionHandler
		@ResponseStatus(code = HttpStatus.BAD_REQUEST)
		public RestResponseError handleException(DuplicatedTaskException e) {
			return RestResponseError.fromMessage(e.getMessage());
			
	}
	
}
