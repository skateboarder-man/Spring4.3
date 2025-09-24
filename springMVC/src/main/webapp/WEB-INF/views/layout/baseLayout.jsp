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

   <main id="body">
       <tiles:insertAttribute name="body" />
   </main>

   <footer id="footer">
       <tiles:insertAttribute name="footer" />
   </footer>
 
 </body>
   
</html>
