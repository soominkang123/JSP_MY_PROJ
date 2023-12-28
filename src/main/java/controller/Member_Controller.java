package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Member.MemberDAO;
import Member.MemberDTO;

//http://localhost:8181/JSP_MVC_M2/*.ab
@WebServlet("*.ab")
public class Member_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Member_Controller() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("ab요청을 처리하는 controller");
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		System.out.println("===================");
		
		if(path.equals("/insertMember.ab")) {
			System.out.println("/insertMember.ab 요청");
			
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			
			
			MemberDTO dto = new MemberDTO();
			dto.setPassword(password);
			dto.setPhone(phone);
			dto.setEmail(email);
			
			
			MemberDAO dao = new MemberDAO();
			dao.insertMember(dto);
			
			response.sendRedirect("getMemberList.ab");
				
		} else if (path.equals("/getMemberList.ab")) {
			System.out.println("/getMemberList.ab 요청");
			
			MemberDTO dto = new MemberDTO();
			
			MemberDAO dao = new MemberDAO();
			
			List<MemberDTO> memberList = new ArrayList<>();
			
			memberList = dao.getMemberList(dto);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("memberList", memberList);
			System.out.println("memberList : " + memberList);
			
			response.sendRedirect("getMemberList.jsp");
			
			
		} else if (path.equals("/getMember.do")) {
			System.out.println("/gdtMember.do 요청");
								
			String ID = request.getParameter("ID");
			
			MemberDTO dto = new MemberDTO();
			dto.setId(ID);
						
			MemberDAO dao = new MemberDAO();
			
			MemberDTO member = new MemberDTO();
			dto.setId(ID);
			
			// 4. 뷰 페이지 전송
			HttpSession session = request.getSession();
			
			session.setAttribute("member",member);
			
			//5. 뷰페이지
			
			response.sendRedirect(ID);
			
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
