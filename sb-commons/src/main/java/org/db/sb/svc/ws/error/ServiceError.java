package org.db.sb.svc.ws.error;

import org.springframework.http.HttpStatus;

public enum ServiceError implements WsError {

	UNAUTHORIZED_401(401, HttpStatus.UNAUTHORIZED),
	LOGIN_FAILED(422, HttpStatus.UNPROCESSABLE_ENTITY),
	INTERNAL_SERVER_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR);

	private int errorCode;
	private HttpStatus httpStatus;

	private ServiceError(int errorCode, HttpStatus httpStatus) {
		this.errorCode = errorCode;
		this.httpStatus = httpStatus;
	}

	@Override
	public int getErrorCode() {
		return errorCode;
	}

	@Override
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
