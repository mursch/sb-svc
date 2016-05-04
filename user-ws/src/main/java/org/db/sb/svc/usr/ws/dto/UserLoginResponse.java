package org.db.sb.svc.usr.ws.dto;

public class UserLoginResponse {

	private String token;

	public static UserLoginResponse create(String token) {
		return new UserLoginResponse(token);
	}

	private UserLoginResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
