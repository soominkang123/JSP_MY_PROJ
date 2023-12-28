package Member;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberDTO {

	private String ID;
	private String PASSWORD;
	private String PHONE;
	private String EMAIL;
	private Date regdate;
	private String addr;
	private String ROLE;

	
	
	
	
}
