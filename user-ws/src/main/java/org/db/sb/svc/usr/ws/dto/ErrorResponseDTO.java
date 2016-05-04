package org.db.sb.svc.usr.ws.dto;

public class ErrorResponseDTO {

	private int errorCode;
	private String message;

	public ErrorResponseDTO() {
	}

	public ErrorResponseDTO(int errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
