package co.spring.mvc.security.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import co.spring.mvc.user.service.UserVO;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private final UserVO userVo;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 // 실제로는 userVo.getRole() 등의 메서드를 통해 DB에서 권한을 가져와야 합니다.
        // 여기서는 임시로 "ROLE_USER" 권한을 부여합니다. 
		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userVo.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userVo.getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true; // 만료되지 않음 (필요에 따라 userVo의 상태 필드를 참조하여 구현)
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true; // 잠금되지 않음
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true; // 비밀번호 만료되지 않음
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return "N".equalsIgnoreCase(userVo.getIsDeleted());
	}
	
	public UserVO getUserVo() {
		return userVo;
	}
	
	

}
