package org.db.sb.svc.ws.error;

import org.springframework.http.HttpStatus;

public interface WsError {

	int getErrorCode();

	HttpStatus getHttpStatus();

}
