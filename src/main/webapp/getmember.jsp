<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "Member.MemberDTO" %>  

<%
    MemberDTO member = new MemberDTO();

    member = (MemberDTO) session.getAttribute("member");
 
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
  <h1> 글 상세 페이지 (수정 가능하도록)</h1>
      <hr>
      <br><br>
      <form method = "post"action = "updateMember.do" >
     
     <input type = "hidden" name = "ID" value = "<%= member.getID() %>">
     
      <table border="1" width = "700px" cellpadding = "10px" >
             <tr><td bgcolor="skyblue" align = "center"> 아이디 </td> 
             <td> <input type= "text" name = "title" value="<%= member.getID()%>"> </td>
             </tr>
             
             <tr><td bgcolor="skyblue" align = "center"> 비밀번호 </td> 
             <td> <input type= "text" name = "title" value="<%= member.getPASSWORD()%>"> </td>
             </tr>
             
             <tr><td bgcolor="skyblue" align = "center"> 폰번호 </td> 
             <td> <input type= "text" name = "title" value="<%= member.getPHONE()%>"> </td>
             </tr>
             
             <tr><td bgcolor="skyblue" align = "center"> 이메일 </td> 
             <td> <input type= "text" name = "title" value="<%= member.getEMAIL()%>"> </td>
             </tr>
             
             <tr><td bgcolor="skyblue" align = "center"> 가입일 </td> 
             <td> <input type= "text" name = "title" value="<%= member.getRegdate()%>"> </td>
             </tr>
             
             <tr><td bgcolor="skyblue" align = "center"> 주소 </td> 
             <td> <input type= "text" name = "title" value="<%= member.getAddr()%>"> </td>
             </tr>
             
             <tr><td bgcolor="skyblue" align = "center"> 회원역할 </td> 
             <td> <input type= "text" name = "title" value="<%= member.getROLE()%>"> </td>
             </tr>
             
              <tr><td colspan = "2" align = "center"> <input type="submit" value= "글 수정하기"> </td> 
     
             </tr>
     
     </table>     
     </form>

       <br><br>
       <a href = "deleteMember.do?ID=<%= member.getID()%>" >
         글 삭제
         </a>




</center>
</body>
</html>