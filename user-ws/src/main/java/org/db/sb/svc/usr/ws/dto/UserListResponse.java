package org.db.sb.svc.usr.ws.dto;

import java.util.List;

public class UserListResponse {

	private List<UserDTO> users;

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
}
