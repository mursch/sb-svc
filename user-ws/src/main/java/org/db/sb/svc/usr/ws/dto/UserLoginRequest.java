package org.db.sb.svc.usr.ws.dto;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

public class UserLoginRequest {

	@ApiModelProperty(required = true)
	@NotEmpty
	private String username;
	@ApiModelProperty(required = true)
	@NotEmpty
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
