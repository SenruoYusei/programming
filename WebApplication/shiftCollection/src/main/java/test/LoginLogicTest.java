package test;

import model.LoginLogic;
import model.Member;
import model.User;
public class LoginLogicTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		testExecute1();
		testExecute2();
	}
	public static void testExecute1() {
		User u = new User("中野泰俊","1111");
		LoginLogic llogic = new LoginLogic();
		Member m = llogic.getLoginAccount(u);
		if(m != null)System.out.println("testExecute1 : 成功しました");
		else System.out.println("testExecute1 : 失敗しました");
	}
	public static void testExecute2() {
		User u = new User("中野泰俊","1234");
		LoginLogic llogic = new LoginLogic();
		Member m = llogic.getLoginAccount(u);
		if(m == null)System.out.println("testExecute2 : 成功しました");
		else System.out.println("testExecute2 : 失敗しました");
	}
}
