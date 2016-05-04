package org.db.sb.svc.usr.config;

import org.db.sb.svc.usr.ws.dto.ErrorResponseDTO;
import org.db.sb.svc.ws.error.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = {"org.db.sb.svc.usr.ws"})
public class WsExceptionHandler extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<T>
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDTO> handleException(Exception e) {
		ErrorResponseDTO dto = null;
		HttpStatus httpStatus = null;
		if (e instanceof ServiceException) {
			ServiceException se = (ServiceException) e;
			dto = new ErrorResponseDTO(se.getErrorCode(), e.getMessage());
			httpStatus = se.getHttpStatus();
		} else {
			dto = new ErrorResponseDTO(99, e.getMessage());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<ErrorResponseDTO>(dto, httpStatus);
	}


}
