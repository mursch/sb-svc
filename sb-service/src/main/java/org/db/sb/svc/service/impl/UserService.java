package org.db.sb.svc.service.impl;

import org.db.sb.svc.domain.entity.User;
import org.db.sb.svc.service.IUserService;
import org.db.sb.svc.ws.error.ServiceError;
import org.db.sb.svc.ws.error.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService implements IUserService {

	@Override
	public User login(String username, String password) {
		if ("qwer@qwer.com".equals(username)) {
			throw new ServiceException(ServiceError.LOGIN_FAILED, "Login failed - invalid username or password.");
		}
		User user = new User();
		user.setId(123l);
		user.setUsername("jd");
		user.setFirstname("John");
		user.setLastname("Doe");
		return user;
	}

}
