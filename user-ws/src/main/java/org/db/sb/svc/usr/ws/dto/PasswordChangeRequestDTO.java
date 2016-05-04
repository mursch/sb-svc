package org.db.sb.svc.usr.ws.dto;

public class PasswordChangeRequestDTO {

	private String oldPassword;
	private String newPassword;
	private String newPasswordConfirmed;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPasswordConfirmed() {
		return newPasswordConfirmed;
	}

	public void setNewPasswordConfirmed(String newPasswordConfirmed) {
		this.newPasswordConfirmed = newPasswordConfirmed;
	}
}
