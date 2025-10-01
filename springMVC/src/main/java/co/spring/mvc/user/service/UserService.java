package co.spring.mvc.user.service;

import java.util.Map;


public interface UserService {

	Map<String, Object> getDepartmentList() throws Exception;

	Map<String, Object> singUp(UserVO userVO) throws Exception;

	Map<String, Object> checkId(UserVO userVO) throws Exception;

}
