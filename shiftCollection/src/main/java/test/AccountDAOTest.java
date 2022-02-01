package test;

import model.LoginLogic;
import model.Member;
import model.User;

public class AccountDAOTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		testFindByUser1();
		testFindByUser2();
	}
	public static void testFindByUser1() {
		User u = new User("中野泰俊","1111");
		LoginLogic ll = new LoginLogic();
		Member m = ll.getLoginAccount(u);
		if(m != null) {
			System.out.println("testFindByUser1 : 成功しました");
		}else {
			System.out.println("testFindByUser1 : 失敗しました");
		}
	}
	public static void testFindByUser2() {
		User u = new User("中野泰俊","1234");
		LoginLogic ll = new LoginLogic();
		Member m = ll.getLoginAccount(u);
		if(m == null) {
			System.out.println("testFindByUser2 : 成功しました");
		}else {
			System.out.println("testFindByUser2 : 失敗しました");
		}
	}
}
