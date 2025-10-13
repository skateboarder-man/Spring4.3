package co.spring.mvc.user.service;

import java.sql.Timestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class UserVO {
	
	private int memberId;
	
	private String userId;
	
    private String password;
    
    private String confirmPassword;
	
    private String name;
	
    private String email;
    
    private String phoneNumber;
    
	private int failCnt;   // 실패 횟수
	
	private String userGrade;
	
    private int departmentId;
	
    private String isDeleted;
    
    private Timestamp createdAt;
    
    private Timestamp updatedAt;
    
    private String lockUser;

}
