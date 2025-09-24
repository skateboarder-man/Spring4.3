package co.spring.mvc.user.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface UserMapper {

	List<Map<String, Object>> getDepartmentList() throws Exception;

}
