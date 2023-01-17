package com.waseel.dawy.interceptor;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class HeaderInterceptor implements HandlerInterceptor {

	private static final String[] BY_PASS_URLS = { "/health", "/login", "/company/forgot-password",
			"/company/confirm-email" };

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}

	private static final boolean isByPassURL(HttpServletRequest request) {
		return Arrays.stream(BY_PASS_URLS).anyMatch(request.getRequestURI()::contains);
	}
}
