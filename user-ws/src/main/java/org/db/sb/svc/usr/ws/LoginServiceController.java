package org.db.sb.svc.usr.ws;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.db.sb.svc.domain.entity.User;
import org.db.sb.svc.service.impl.UserService;
import org.db.sb.svc.usr.ws.dto.UserLoginRequest;
import org.db.sb.svc.usr.ws.dto.UserLoginResponse;
import org.db.sb.svc.utils.JwtUtils;
import org.db.sb.svc.ws.AbstractServiceController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Component
@RestController
@RequestMapping(LoginServiceController.BASE_PATH_LOGIN)
public class LoginServiceController extends AbstractServiceController {

	private static Logger LOG = LoggerFactory.getLogger(LoginServiceController.class);

	public static final String LOGIN_V1 = "v1/login";

	@Autowired
	private UserService userService;

	@RequestMapping(
			path = LOGIN_V1,
			method = RequestMethod.POST)
	@ApiOperation(
			value = "User login",
			notes = "Comment",
			response = UserLoginResponse.class)
	@ApiResponses({
		@ApiResponse(code = 400, message = "error: 400 - Validation Error")
	})
	public UserLoginResponse login(@RequestBody @ApiParam(value = "The user login information.") @NotNull @Valid UserLoginRequest userLoginReqeust) {
		LOG.info("login attempt user: {}", userLoginReqeust.getUsername());
		User user = userService.login(userLoginReqeust.getUsername(), userLoginReqeust.getPassword());
//		Key key = MacProvider.generateKey(SignatureAlgorithm.HS512);
		String token = JwtUtils.createToken(user);
		return UserLoginResponse.create(token);
	}

}
