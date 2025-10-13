package co.spring.mvc.user.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import co.spring.mvc.user.service.UserVO;

@Mapper
public interface UserMapper {

	List<Map<String, Object>> getDepartmentList() throws Exception;

	int singUp(UserVO userVO) throws Exception;

	int IdCnt(UserVO userVO) throws Exception;

	UserVO findByUser(String username) ; // Spring Security의 계약에 따라 오직 **UsernameNotFoundException**만을 던지도록 선언

	int incrementFailureCount(String username);
	
	int getFailureCount(String username);

	int lockUserAccount(String username);

	boolean checkUserExists(String username);

	int resetFailCountAndUnlockUser(String username);

}
