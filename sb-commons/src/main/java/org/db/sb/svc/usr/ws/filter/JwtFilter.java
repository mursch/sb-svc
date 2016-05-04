package org.db.sb.svc.usr.ws.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.db.sb.svc.utils.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtFilter extends GenericFilterBean {

	private static Logger LOG = LoggerFactory.getLogger(JwtFilter.class);

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) req;

		LOG.info("JWTFilter Http-Method {}", request.getMethod());

		// @TODO options request
		if (!HttpMethod.OPTIONS.name().equals(request.getMethod())) {
			boolean authorized = false;
			try {
				authorized = checkAuthHeader(request, (HttpServletResponse) res);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			if (!authorized) {
				return;
			}
		}

		chain.doFilter(req, res);
	}

	private boolean checkAuthHeader(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
		final String authHeader = request.getHeader("Authorization");
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			prepareUnauthorizedRepsonse(response);
			return false;
		}

		final String token = authHeader.substring(7); // The part after "Bearer"

		try {
			final Claims claims = JwtUtils.extractClaims(token);
			request.setAttribute(JwtUtils.REQUEST_ATTRIBUTE_CLAIMS, claims);
		} catch (final SignatureException e) {
			prepareUnauthorizedRepsonse(response);
			return false;
		}

		return true;
	}

	private void prepareUnauthorizedRepsonse(final HttpServletResponse response) {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setHeader("Access-Control-Allow-Origin", "*");
	}

}
