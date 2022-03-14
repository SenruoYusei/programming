package model;
import dao.MemberDAO;

public class LoginLogic {
	private MemberDAO dao;
	public LoginLogic() {
		dao = new MemberDAO();
	}
	public MemberSet getMemberList(){
		return dao.findAll();
	}
	public Member getLoginAccount (String userName, String userPass) {
		return dao.findMember(userName, userPass);
	}
	public void updateAll(Member m) {
		dao.updateAll(m);
	}
}
