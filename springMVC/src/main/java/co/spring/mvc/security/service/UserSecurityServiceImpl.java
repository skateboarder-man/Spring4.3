package co.spring.mvc.security.service;


import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import co.spring.mvc.user.service.UserVO;
import co.spring.mvc.user.service.impl.UserMapper;
import co.spring.mvc.user.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;

@Service("userSecurityService")
@RequiredArgsConstructor
public class UserSecurityServiceImpl extends EgovAbstractServiceImpl implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private final UserMapper userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserVO userVo = userDAO.findByUser(username);
		
		if(userVo == null) {
			LOGGER.info("없는거야?");
			throw new UsernameNotFoundException("사용자 ID [" + username + "]를 찾을 수 없습니다.");
		}
		
		return new CustomUserDetails(userVo);
	}


}
