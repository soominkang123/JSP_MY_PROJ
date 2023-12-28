<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>    
<%@ page import = "Member.MemberDTO" %>    

<%
List<MemberDTO> memberList = new ArrayList<>();

try {
	memberList = (List) session.getAttribute("memberList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
      <center>
      <h1>글 목록</h1>
      <hr>
      
      <table border="1" width="700px">
			<tr>
				<th bgcolor="skyblue" width="100px">아이디</th>
				<th bgcolor="skyblue" width="100px">비밀번호</th>
				<th bgcolor="skyblue" width="100px">이메일 주소</th>
				<th bgcolor="skyblue" width="100px">회원가입일</th>
				<th bgcolor="skyblue" width="100px">주소</th>
				<th bgcolor="skyblue" width="100px">회원역할</th>
			</tr>
		
		<%
		for (MemberDTO m : memberList) {
		%>	
		<tr>
		   <td align= "center"> <%=m.getID()%></td>
		   
		   <td><a href="getMember.do?id = <%= m.getID() %>"><%= m.getPASSWORD() %>
		   aa</a></td>
		   
		   <td><%=m.getPHONE() %></td>
		   <td><%=m.getEMAIL() %></td>
		   <td><%=m.getRegdate() %></td>
		   <td><%=m.getAddr() %></td>
		   <td><%=m.getROLE() %></td>
		</tr>
			
       <%
		}
		
          } catch(Exception e) {
          	response.sendRedirect("getMemberList.ab");
          }
          %>
      </table>
      
      	<br> <a href="http://localhost:8181/JSP_MVC_PROJ"> 홈으로 </a>
		<p /> <a href= "insertBoard.jsp"> 새 글쓰기</a>
      
      </center>

</body>
</html>