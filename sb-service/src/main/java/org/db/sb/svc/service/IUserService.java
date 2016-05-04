package org.db.sb.svc.service;

import org.db.sb.svc.domain.entity.User;

public interface IUserService {

	User login(String username, String password);

}
