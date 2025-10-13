package co.spring.mvc.Common.web;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.spring.mvc.user.service.UserService;
import co.spring.mvc.user.service.UserVO;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/*")
public class PublicController {
	
	private final UserService userService;
	
	@GetMapping(value = "/getDepartmentList.do")
	@ResponseBody
	public Map<String, Object> getDepartmentList () throws Exception {
		return userService.getDepartmentList();
	}
	
	@PostMapping(value = "/singUp.do")
	@ResponseBody
	public Map<String, Object> singUp (@RequestBody UserVO userVO) throws Exception {
		return userService.singUp(userVO);
	}
	
	@PostMapping(value = "/checkId.do")
	@ResponseBody
	public Map<String, Object> checkId (@RequestBody UserVO userVO) throws Exception {
		return userService.checkId(userVO);
	}
	
}
