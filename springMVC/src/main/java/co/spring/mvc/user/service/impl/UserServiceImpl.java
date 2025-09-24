package co.spring.mvc.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.spring.mvc.user.service.UserService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceImpl extends EgovAbstractServiceImpl implements UserService{
	
		private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	/** SampleDAO */
	private final UserMapper userDAO;
	
	
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

}
