<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<div class="body">
	<div class="login-container">
		<h2>로그인</h2>
		<form action="#" method="post">
		    <div class="input-group">
		        <label for="username">아이디</label>
		        <input type="text" id="username" name="username" required>
		    </div>
		    <div class="input-group">
		        <label for="password">비밀번호</label>
		        <input type="password" id="password" name="password" required>
		    </div>
		    <!-- <input type="submit" value="로그인" class="login-button"> -->
		    <a href="/main" class="register-button-link">로그인</a>
		</form>
	<div class="separator"></div>
	<a href="/register" class="register-button-link">회원가입</a>
	</div>
</div>


<script type="text/javascript">
$(document).ready(function() {
   
});
</script>