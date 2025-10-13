package co.spring.mvc.security.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import co.spring.mvc.user.service.impl.UserMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component("loginSuccessHandler")
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
	
	private final UserMapper userDAO;
	private final String defaultTargetUrl = "/main";
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String username = authentication.getName(); //로그인 성공시 아아디 가져오기.
		
		
		try {
			userDAO.resetFailCountAndUnlockUser(username); 
		}catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
		
		response.sendRedirect(request.getContextPath() + defaultTargetUrl);
	}

}
