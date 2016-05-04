package org.db.sb.svc.utils;

public enum JwtClaim {

	USER_ID("user_id"), USER_GROUP("user_group");

	private String name;

	private JwtClaim(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
