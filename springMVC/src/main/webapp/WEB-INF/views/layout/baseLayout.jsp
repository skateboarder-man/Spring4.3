<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>사이트 제목</title>
 </head>
 
 <body>
 
 	<header id="header">
       	<tiles:insertAttribute name="header" />
   </header>

   <main>
       	<tiles:insertAttribute name="body" />
   </main>
   
   <main id="main" class ="main">
	   <div class="d-flex align-items-start">
	   		<tiles:insertAttribute name="menu" />
	       	<tiles:insertAttribute name="main" />
	   </div>
   </main>

   <footer id="footer">
       	<tiles:insertAttribute name="footer" />
   </footer>
 
 </body>
   
</html>
