package co.spring.mvc.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import co.spring.mvc.user.service.UserService;
import co.spring.mvc.user.service.UserVO;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceImpl extends EgovAbstractServiceImpl implements UserService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	private final UserMapper userDAO;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public Map<String, Object> getDepartmentList() throws Exception {
		Map<String, Object> resultMap = new HashMap<String,Object>();
		List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
		dataList = userDAO.getDepartmentList();
		
		if(dataList.size() < 1) {
			resultMap.put("msg","Not Found");
			resultMap.put("code","404");
			return resultMap;
		}
		
		resultMap.put("data",dataList);
		resultMap.put("code","200");
		
		return resultMap;
	}


	@Override
	public Map<String, Object> singUp(UserVO userVO) throws Exception {
		Map<String, Object> resultMap = new HashMap<String,Object>();
		String password  = userVO.getPassword();
		String confirmPassword = userVO.getConfirmPassword();
		String encodedPassword = "";
		
		if(!password .equals(confirmPassword)) {
			resultMap.put("msg","비밀번호 입력이 일치하지 않습니다.");
			resultMap.put("code","500"); 
			return resultMap;
		}
		
		int IdCnt = userDAO.IdCnt(userVO); // 아이디 중복검사
		
		if(IdCnt > 0) {
			resultMap.put("msg","같은아이디가 존재 합니다.");
			resultMap.put("code","500"); 
			return resultMap;
		}
		
		try {
			encodedPassword = passwordEncoder.encode(password);
		}catch(Exception e){
			LOGGER.debug(e.getMessage());
		}
		
		userVO.setPassword(encodedPassword);
		int checkInt = userDAO.singUp(userVO);
		
		if(checkInt < 1) { 
			resultMap.put("msg","회원가입 실패");
			resultMap.put("code","500");
			return resultMap; 
		}
		
		resultMap.put("msg","회원가입 완료.");
		resultMap.put("code","200"); 
		return resultMap;
	}


	@Override
	public Map<String, Object> checkId(UserVO userVO) throws Exception {
		Map<String, Object> resultMap = new HashMap<String,Object>();
		
		if(userVO.getUserId() =="" || userVO.getUserId() ==null) {
			resultMap.put("msg","필수값 누락되었습니다.");
			resultMap.put("code","400"); 
			return resultMap;
		}
		
		int IdCnt = userDAO.IdCnt(userVO); // 아이디 중복검사
					
		if(IdCnt > 0) {
			resultMap.put("msg","같은아이디가 존재 합니다.");
			resultMap.put("code","500"); 
			return resultMap;
		}
		resultMap.put("code","200");
		resultMap.put("msg","사용가능한 아이디 입니다.");
		return resultMap;
	}
		

}
