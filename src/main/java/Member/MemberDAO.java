package Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;

public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private final String MEMBER_INSERT = "insert into Member(id, password, phone,email,regdate,addr,role)"
			+ "values (( select nvl (max(seq),0) + 1 from member) , ? , ? , ? )";
	
	private final String MEMBER_LIST = "select*from member order by id desc";
	
	private final String MEMBER_GET = "select * from member where seq = ?";
	
	private final String MEMBER_UPDATE = "update member set title= ? , write= ? , content= ? where seq= ?";
	
	private final String MEMBER_DELETE = "delete member where id = ?";
	
	private final String ADD_ROLE = "update board set role = role + 1 where id = ?";
	
	// insertMember(MemberDTO dto) 메소드	
	public void insertMember(MemberDTO dto) {
		System.out.println("insertMember 기능 처리 =");
	
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(MEMBER_INSERT);
		
		 pstmt.setString(1, dto.getPASSWORD());
		 pstmt.setString(2, dto.getPHONE());
		 pstmt.setString(3, dto.getEMAIL());
		 
		 pstmt.executeUpdate();
		 
		 System.out.println("member 테이블에 값이 잘 들어갔다.");
		
	} catch(Exception e) {
		System.out.println("member 테이블에 값이 안들어갔다");
		e.printStackTrace();
		
	} finally {
		JDBCUtil.close(pstmt, conn);
		
	   }
	
	}
	
	public List<MemberDTO> getMemberList(MemberDTO dto) {
		
	      List<MemberDTO> memberList = new ArrayList<>();
	
		try {
			conn = JDBCUtil.getConnection();
			// MEMBER_LIST = "select*from member order by seq desc";
			pstmt = conn.prepareStatement(MEMBER_LIST);
			
			rs = pstmt.executeQuery();			
		
		while (rs.next()) {
			
		MemberDTO member = new MemberDTO();
		member.setID(rs.getString("ID"));
		member.setPASSWORD(rs.getString("PASSWORD"));
		member.setPHONE(rs.getString("PHONE"));
		member.setEMAIL(rs.getString("EMAIL"));
		member.setRegdate(rs.getDate("REGDATE"));
		member.setAddr(rs.getString("ADDR"));
		member.setROLE(rs.getString("ROLE"));
		
		memberList.add(member);
		
			
		}
		
	} catch (Exception e) {
		System.out.println("DB Select 실패");
	    e.printStackTrace();
	    
	} finally {
		JDBCUtil.close(rs, pstmt, conn);
		
	}
   return memberList;
   
	 }
	
	
	
	
	}
