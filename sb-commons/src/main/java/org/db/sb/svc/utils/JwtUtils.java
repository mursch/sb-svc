package org.db.sb.svc.utils;

import javax.servlet.http.HttpServletRequest;

import org.db.sb.svc.domain.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.compression.CompressionCodecs;

public class JwtUtils {

	/**
	 * TODO property file 
	 */
	private static final String KEY = "NTc4OTZ6ZGxvcjk4NWRvbHI4NXQ2N3dlb2xzODVoOXI5bzhyZTVvOTg3c2RyZTVveGxlcjg1cHFjajg0";

	public static final String REQUEST_ATTRIBUTE_CLAIMS = "claims";

	public static final String createToken(User user) {
		return Jwts.builder()
				.setSubject("subj")
				.claim(JwtClaim.USER_ID.getName(), String.valueOf(user.getId()))
				.claim(JwtClaim.USER_GROUP.getName(), new String[]{"admin", "user"})
//				.compressWith(CompressionCodecs.DEFLATE)
				.signWith(SignatureAlgorithm.HS512, KEY)
				.compact();
	}

	public static Claims extractClaims(String token) {
		return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
	}

	public static Claims getClaims(HttpServletRequest request) {
		return (Claims) request.getAttribute(REQUEST_ATTRIBUTE_CLAIMS);
	}
}
