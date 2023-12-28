<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%
   
   String sessionID = (String) session.getAttribute("id");
   String sessionRole = (String) session.getAttribute("role");
   
   
   %> 
   
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
          <h1>로그인 폼 페이지</h1>
          <hr>
          <p />
          
          <%
             if(sessionID == null) {
          %>
          
          <form method="post"action="login.us">
             <table>
                <tr>
                   <td> ID :</td>
                   <td><input type="text" name="id"></td>
			</tr>
            <tr>
				<td> password :</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type= "submit" value="로그인">
				</td>
			</tr>
			
			</table>
	</form>	
		<p /> <a href="http://localhost:8181/JSP_MY_PROJ"> 홈으로 </a>
			
			<%
			
		        } else {
						
			%>
			    <%= sessionID %> 님 로그인 되었습니다. <p />
			    당신의 권한은 <%=sessionRole %> 입니다.<p />
			    
			    <a href = "logout.us"> 로그아웃</a>
			    
			  <%
			      }
			  %>  
          
          
             
         
</body>
</html>