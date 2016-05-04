package org.db.sb.svc.usr.ws;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.db.sb.svc.usr.ws.dto.PasswordChangeRequestDTO;
import org.db.sb.svc.usr.ws.dto.UserDTO;
import org.db.sb.svc.usr.ws.dto.UserListRequest;
import org.db.sb.svc.usr.ws.dto.UserListResponse;
import org.db.sb.svc.utils.JwtUtils;
import org.db.sb.svc.ws.AbstractServiceController;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Component
@RestController
@RequestMapping(UserServiceController.BASE_API_PATH)
public class UserServiceController extends AbstractServiceController {

	private static final String V1 = "v1/";

	public static final String USERS_V1 = V1 + "users";
	public static final String SAVE_V1 = V1 + "user/{userId}/save";
	public static final String PASSWORD_V1 = V1 + "user/{userId}/password";

	@RequestMapping(
			path = USERS_V1,
			method = RequestMethod.GET)
	@ApiOperation(
			value = "returns a list of all users",
			notes = "Comment",
			response = UserListResponse.class)
	@ApiResponses({
		@ApiResponse(code = 400, message = "error: 400 - Validation Error")
	})
	public UserListResponse getUsers(@ApiParam(value = "user list request") UserListRequest userListRequest,
			final HttpServletRequest request) {

//		Claims claims = JwtUtils.getClaims(request);

		UserListResponse response = new UserListResponse();
		response.setUsers(new ArrayList<>());
		response.getUsers().add(new UserDTO(0l, "hGrub", "Hans", "Gruber"));
		response.getUsers().add(new UserDTO(1l, "wWand", "Wolfgang", "Wandl"));
		return response;
	}

	@RequestMapping(
			path = SAVE_V1,
			method = RequestMethod.POST)
	@ApiOperation(
			value = "saves the given user",
			notes = "Comment",
			response = UserDTO.class)
	@ApiResponses({
		@ApiResponse(code = 400, message = "error: 400 - Validation Error")
	})
	public UserDTO save(@PathVariable Long userId,
			@RequestBody @ApiParam(value = "The user login information.") @NotNull @Valid UserDTO userDTO) {
		
		return userDTO;
	}

	@RequestMapping(
			path = PASSWORD_V1,
			method = RequestMethod.PUT)
	@ApiOperation(
			value = "changes the password of the given user",
			notes = "Comment")
	@ApiResponses({
		@ApiResponse(code = 400, message = "error: 400 - Validation Error")
	})
	public void changePassword(@PathVariable Long userid,
			@RequestBody @ApiParam(value = "The password change information.") @NotNull @Valid PasswordChangeRequestDTO pwdCahngeRequestDTO) {
		
	}
}
