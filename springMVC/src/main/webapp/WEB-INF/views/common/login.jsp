<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<!DOCTYPE html>
<div class="body">
	<div class="login-container">
		<h2>로그인</h2>
		<form action="${pageContext.request.contextPath}/signIn" method="post">
		    <div class="input-group">
		        <label for="username">아이디</label>
		        <input type="text" id="username" name="username" required>
		    </div>
		    <div class="input-group">
		        <label for="password">비밀번호</label>
		        <input type="password" id="password" name="password" required>
		    </div>
		   <input type="submit" value="로그인" class="login-button">
		</form>
	<div class="separator"></div>
	<a href="/register" class="register-button-link">회원가입</a>
	</div>
</div>


<script type="text/javascript">


var failMessage = '<c:out value="${sessionScope.loginFailMessage}"/>';


if (failMessage !== '' && failMessage !== 'null') {
    alert(failMessage);
    
    // 메시지를 한 번 보여준 후 세션에서 제거하여 중복 알림 방지
   <c:remove var="loginFailMessage" scope="session"/>
}


$(document).ready(function() {
   
});
</script>