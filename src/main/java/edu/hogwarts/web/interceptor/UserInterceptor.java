package edu.hogwarts.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.hogwarts.persistence.entity.User;
import edu.hogwarts.util.HogwartsConstants;

public class UserInterceptor extends HandlerInterceptorAdapter {

	private static Logger logger = LoggerFactory.getLogger(UserInterceptor.class);
	
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse repsonse, Object handler) {
//		logger.debug("Entered preHandle()");
//		return true;
//	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		logger.info("Entered postHandle() - {}", request.getRequestURI());
		
		HttpSession session = request.getSession();
		logger.info("Session Id: {}", session.getId());
		logger.info("Session Create Time: {}", session.getCreationTime());
		logger.info("Session Last Accessed Time: {}", session.getLastAccessedTime());
		
		try {
			if (session != null && session.getAttribute(HogwartsConstants.ATTRIBUTE_CURRENT_USER) == null) {
				if (request.getRequestURI().contains("restricted")) {
					logger.info("The user is not logged in, redirect to login page {}", request.getRequestURI());
					response.sendRedirect(request.getContextPath());
					return false;
				}
			} else {
				User user = (User) session.getAttribute(HogwartsConstants.ATTRIBUTE_CURRENT_USER);
				logger.info("User {} is accessing {}", user.getEmail(), request.getRequestURI());
			}
		} catch (Exception e) {
			logger.error("Failed to check user session.", e);
		}
		return true;
	}
	
}
