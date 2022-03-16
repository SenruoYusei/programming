package model;
import dao.MemberDAO;
//メンバーのid をどこに定義するか
public class LoginLogic {//ユーザー登録の際に登録情報を持ちたい
	private MemberSet members;
	private Member manager;
	private MemberDAO dao;
	public LoginLogic() {
		dao = new MemberDAO();
		members = dao.findAll();
		manager = new Member(99,"***","7777",0,0);
	}
	public MemberSet getMemberList(){
		//return members;
		return dao.findAll();
	}
	/*
	public Member getLoginAccount (User u) {
		if(manager.isMatched(u))return manager;
		for(Member m : members) {
			if(m.isMatched(u))return m;
		}
		return null;
	}
	*/
	
	public Member getLoginAccount (String userName, String userPass) {
		return dao.findMember(userName, userPass);
		/*
		if(manager.isMatched(userName, userPass))return manager;
		for(Member m : members) {
			if(m.isMatched(userName, userPass))return m;
		}
		return null;
		*/
	}
	public void updateAll(Member m) {
		dao.updateAll(m);
	}
	/*
	public boolean canBeLogined (User u) {//ログイン可能かを判断　Memberの　ArrayList　に u が含まれるか
		for(Member m : members) {
			if(m.isMatched(u)) return true;		
		}
		return false;
	}
	*/
	/*
	public void setData() {
		MemberDAO dao = new MemberDAO();
		dao.findAll(this);
	}
	public boolean execute(User u) {//ユーザーがmember に含まれている値と一致すれば，そのID を返す
		for(Member m : this) {
			if(!m.isMatched(u))continue;
			u.setId(getId(u.getName()));
			return true;
		}
		return false;
	}
	public int getId(String na) {
		for(int i = 0;i < idTable.length; i++) {
			if(idTable[i].equals(na))return i;
		}
		return -1;
	}
	*/
}
