package com.sutton.sweatweb.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*") // * make sure this url pattern matches all the pattern,so it will be called
					// always and make sure
//it is called before sevrlet
public class CheckSessionFilter implements Filter {

	private final String LOGIN_URL = "sweatweb/login";
	private final String INDEX_URL = "sweatweb/index.html";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		 * 
		 * 
		 * http://localhost:8110/sweatweb/login http://localhost:8110/sweatweb/main.html
		 */

		boolean cookieFound = false;

		// If request is not index page or login, Check cookie
		String url = ((HttpServletRequest) request).getRequestURL().toString();
		if (url.toLowerCase().endsWith(LOGIN_URL) || url.toLowerCase().endsWith(INDEX_URL)) {

			chain.doFilter(request, response);

		} else {

			Cookie[] cookies = ((HttpServletRequest) request).getCookies();
			for (Cookie cookie : cookies) {
				// find cookie
				if (cookie.getName().equalsIgnoreCase(CookieValues.COOKIE_NAME)) {

					// Validate value
					String cookieVal = cookie.getValue();
					if (CookieValues.valueExist(cookieVal)) {
						cookieFound = true;
						// reset cookie expiration (every 2 mins)
						cookie.setMaxAge(CookieValues.COOKIE_EXP); 
						((HttpServletResponse) response).addCookie(cookie);
						// go find according sevrlet
						chain.doFilter(request, response);
					}
					break;
				}
			}
			if (!cookieFound) {
				((HttpServletResponse) response).sendRedirect("index.html");
			}
		}

	}

	@Override
	public void destroy() {

	}

}
