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

}
