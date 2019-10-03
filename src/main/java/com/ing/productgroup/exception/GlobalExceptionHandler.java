package com.ing.productgroup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.ing.productgroup.dto.ResponseDto;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(INGProductGroupException.class)
	public ResponseEntity<ResponseDto> lmsExceptionHandler(INGProductGroupException ex, WebRequest request) {

		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(ex.getMessage());
		responseDto.setStatusCode(601);
		return new ResponseEntity<>(responseDto, HttpStatus.UNAUTHORIZED);

	}
	
	@ExceptionHandler(HttpStatusCodeException.class)
	public ResponseEntity<String> lmsExceptionHandler(HttpStatusCodeException ex, WebRequest request) {

		return ResponseEntity.status(ex.getRawStatusCode()).body(ex.getResponseBodyAsString());

	}

}