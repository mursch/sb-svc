package org.db.sb.svc.ws.error;

import org.springframework.http.HttpStatus;

public class ServiceException extends RuntimeException {

	private ServiceError error;
	private String message;
	private Throwable rootCause;

	public ServiceException(ServiceError error, Throwable rootCause) {
		this.error = error;
		this.rootCause = rootCause;
	}

	public ServiceException(ServiceError error, String message) {
		this.error = error;
		this.message = message;
	}

	public int getErrorCode() {
		return error != null ? error.getErrorCode() : ServiceError.INTERNAL_SERVER_ERROR.getErrorCode();
	}

	public HttpStatus getHttpStatus() {
		return error != null && error.getHttpStatus() != null ? error.getHttpStatus() : HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public ServiceException(ServiceError error) {
		this.error = error;
	}

	public ServiceError getError() {
		return error;
	}

	public Throwable getRootCause() {
		return rootCause;
	}

	public String getMessage() {
		return message;
	}

}
