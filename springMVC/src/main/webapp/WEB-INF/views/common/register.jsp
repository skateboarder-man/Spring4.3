<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="/css/style.css">

<!DOCTYPE html>
<div class="body">
	<div class="register-container">
	    <h2>회원가입</h2>
	    <form id="singupForm" action="/singup" method="post">
	        <div class="input-group">
	            <label for="userId">아이디</label>
	            <input type="text" id="userId" name="userId" required>
	        </div>
	        <button onclick="checkId();">아이디 중복체크</button>
	        <div class="input-group">
	            <label for="password">비밀번호</label>
	            <input type="password" id="password" name="password" required>
	        </div>
	        <div class="input-group">
	            <label for="confirmPassword">비밀번호 확인</label>
	            <input type="password" id="confirmPassword" name="confirmPassword" required>
	        </div>
	        <div class="input-group">
	            <label for="email">이메일</label>
	            <input type="email" id="email" name="email" required>
	        </div>
	        <div class="input-group">
	            <label for="departmentId">부서선택</label>
	            <select id="departmentId" name="departmentId" required>
	            
	            </select>
	        </div>
	        <input type="submit" value="가입하기" class="register-button">
	    </form>
	</div>
</div>

<Script type="text/javascript">

$(document).ready(function() {
	departmentSelectBox('#departmentId','선택');
	singUp();
});


const singUp = () => {
	$("#singupForm").submit(function(event) {
		 event.preventDefault();
		 const jsonData  = formToJson($(this).serializeArray());
		 
		 $.ajax({
			 url:"public/singUp.do"
					, contentType:"application/json; charset=utf-8"
					, type:"POST"
					, data: JSON.stringify(jsonData)
					, dataType: "json"
					, async : true
					, success: function(response){
						
						if(response.code !='200'){
							alert('MESSAGE: '+ response.msg +'ERROR_CODE: '+response.code)
							return 
						}
						
						makeSelectBox(id, firstOp, response.data);
						
					}
					, error: function(request, status, error){
						console.log(error);
						console.log(request);
					}
				})
		 });
}


const checkId = () => {
	
	cont jsonData={
			"userId" : $('#userId').val()
	}
	
	$.ajax({
		 url:"public/checkId.do"
				, contentType:"application/json; charset=utf-8"
				, type:"POST"
				, data: JSON.stringify(jsonData)
				, dataType: "json"
				, async : false
				, success: function(response){
					
					if(response.code !='200'){
						alert('MESSAGE: '+ response.msg +'ERROR_CODE: '+response.code)
						return 
					}
					
					console.log(response);
					
				}
				, error: function(request, status, error){
					console.log(error);
					console.log(request);
				}
			})
	 });
}


</Script>