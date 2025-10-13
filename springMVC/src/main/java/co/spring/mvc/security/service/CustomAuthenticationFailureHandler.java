package co.spring.mvc.security.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import co.spring.mvc.user.service.impl.UserMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component("loginFailureHandler")
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationFailureHandler.class);
	private final UserMapper userDAO;
	private final String defaultFailureUrl = "/";

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		String username = request.getParameter("username");
		String errorMessage = "로그인에 실패하였습니다. 아이디와 비밀번호를 다시 확인해주세요."; 
		
		if (exception instanceof BadCredentialsException) { //ID가 없어도 비밀번호가 틀려도 해당 Exception 발생
			
			boolean userExists = userDAO.checkUserExists(username); // 사용자 있는지 조회
			LOGGER.info("시작하는겨"+userExists);
			LOGGER.info("시작하는겨");
			
			if (userExists) {
				
				try {
					userDAO.incrementFailureCount(username); // 비밀번호 잘못입력시 fail_cnt 증가
					int failCount = userDAO.getFailureCount(username);  // fail_cnt 가져오기
					
					LOGGER.info("실패카운터는 가져오는겨?"+failCount);
					
					if(failCount >= 5) { // 5회 이상 잘못 입력시 계정 잠금.
						 userDAO.lockUserAccount(username);
						 errorMessage = "비밀번호 5회 오류로 계정이 잠금 처리되었습니다. 관리자에게 문의하세요.";
						 LOGGER.info(errorMessage);
					} else {
						errorMessage += " (실패 횟수: " + failCount + "회)";
						LOGGER.info(errorMessage);
					}
					
				} catch(Exception dbException) {
					LOGGER.debug("비밀번호 실패껀수 등록 실패");
				}
				
			} else {
				LOGGER.info("없는 사용자 로그인");
			}

		}else {
			LOGGER.info("로그인 에러 발생" + exception.getMessage());
		}
		request.getSession().setAttribute("loginFailMessage", errorMessage);
		response.sendRedirect(request.getContextPath() + defaultFailureUrl);
	}
}
