package BEAN;

public class Member {
	private int memberid;
	private String name;
	private String membername;
	private String memberpass;
	private int categorymemberid;
	
	public Member(String name, String membername) {
		super();
	}
	
	public Member() {
		super();
	}

	public Member(int memberid, String membername, String memberpass, int categorymemberid, String name) {
		super();
		this.memberid = memberid;
		this.membername = membername;
		this.memberpass = memberpass;
		this.categorymemberid = categorymemberid;
		this.name = name;
	}
	public Member( String name, String membername,int idmember) {
		// TODO Auto-generated constructor stub
	}public Member(int idmember, String name, String membername) {
		// TODO Auto-generated constructor stub
	}
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getMemberpass() {
		return memberpass;
	}
	public void setMemberpass(String memberpass) {
		this.memberpass = memberpass;
	}
	public int getCategorymemberid() {
		return categorymemberid;
	}
	public void setCategorymemberid(int categorymemberid) {
		this.categorymemberid = categorymemberid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	



}
