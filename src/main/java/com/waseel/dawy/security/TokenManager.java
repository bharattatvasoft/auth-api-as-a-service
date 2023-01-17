package com.waseel.dawy.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.waseel.dawy.entity.Role;
import com.waseel.dawy.entity.UserInfoEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenManager implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 7008375124389347049L;
	public static final long TOKEN_VALIDITY = 10 * 60 * 60;
	@Value("${partner.security.secretKey}")
	private String jwtSecret;

	public String generateJwtToken(UserInfoEntity useInfo) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("userId", useInfo.getUserId());
		claims.put("email", useInfo.getEmail());
		claims.put("fullName", useInfo.getFullName());
		claims.put("password", useInfo.getPassword());
		claims.put("phoneNumber", useInfo.getPhoneNumber());
		claims.put("nationalId", useInfo.getNationalId());
		claims.put("dateOfBirth", useInfo.getDateOfBirth());
		claims.put("nationality", useInfo.getNationality());
		claims.put("username", useInfo.getUsername());
		claims.put("roles", useInfo.getRoles().stream().map(Role::getRoleName).collect(Collectors.toList()));

		return Jwts.builder().setClaims(claims).setSubject(useInfo.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public Claims parseClaims(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
	}

	public Boolean validateJwtToken(String token, UserDetails userInfo) {
		String username = getUsernameFromToken(token);
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		Boolean isTokenExpired = claims.getExpiration().before(new Date());
		return (username.equals(userInfo.getUsername()) && !isTokenExpired);
	}

	public String getUsernameFromToken(String token) {
		final Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	private UserDetails getUserDetails(String token) {
		UserInfoEntity userDetails = new UserInfoEntity();
		Claims claims = parseClaims(token);
		String subject = (String) claims.get(Claims.SUBJECT);
		String roles = (String) claims.get("roles");

		roles = roles.replace("[", "").replace("]", "").replace("(", "").replace(")", "");
		String[] roleNames = roles.split(",");
		for (String aRoleName : roleNames) {
			if (aRoleName.contains("roleName")) {
				
			}
//				userDetails.addRole(new Role(aRoleName.replace("roleName=", "")));
		}

		String[] jwtSubject = subject.split(",");

		userDetails.setUsername(claims.get("username").toString());
		userDetails.setEmail(claims.get("email").toString());
		userDetails.setPassword(claims.get("password").toString());
		return (UserDetails)userDetails;
	}
}
