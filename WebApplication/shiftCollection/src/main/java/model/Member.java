package model;

import java.util.Calendar;

public class Member {
	private int id;
	private String name;
	private String pass;
	String[] s;//希望時間,メモ
	private int term;
	private int dayNum;
	private int month;
	private int dayOfWeek;
	private boolean isUpdated;
	public Member(int i, String na, String pa, int m, int t) {//
		id = i;
		name = na;
		pass = pa;
		setTermInfo(m,t);
	}
	public Member(int i, String na, String pa, int m, int t, String[] time) {//DB の読み取り
		id = i;
		name = na;
		pass = pa;
		setTermInfo(m,t);
		s = time;
		isUpdated = false;
		//sche = new Schedule(dayNum);
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}
	public int getDayNum() {
		return dayNum;
	}
	public String getSchedule(int pos) {
		return s[pos];
	}
	public String[] getAllSchedule() {
		for(int i = 0;i < s.length;i++) {
			if(s[i] == null)s[i] = "";
		}
		return s;
	}
	public int getTermNum() {
		return term;
	}
	public int getMonth() {
		return month;
	}
	
	public void setNewPass(String newPass) {
		if(!isUpdated)isUpdated = true;
		pass = newPass;
	}
	public boolean termChanged(int m, int t) {
		return getMonth() != m || getTermNum() != t;
	}
	public void initializeSchedule(int m, int t) {
		if(!isUpdated)isUpdated = true;
		setTermInfo(m, t);
		s = new String[dayNum];
	}
	
	public void setSchedule(String[] time) {
		s = time;
	}
	public void setSchedule(int dayPos, String time) {
		if(!isUpdated)isUpdated = true;
		s[dayPos] = time;
	}
	public void deleteSchedule(int dayPos) {
		if(!isUpdated)isUpdated = true;
		s[dayPos] = "";
	}
	public String getDay(int index) {
		String[] weekName = {"(日)","(月)","(火)","(水)","(木)","(金)","(土)"};
		return (15 * term + index + 1) + weekName[(dayOfWeek + 15 * term + index) % 7];
	}
	public void updateCompleted() {
		isUpdated = false;
	}
	public boolean isUpdated() {
		return isUpdated;
	}
	/*
	public int getDayNum() {
		return s.length;
		//return dayNum;
	}
	*/
	/*
	public boolean isMatched(User u) {
		return name.equals(u.getName()) && pass.equals(u.getPass());
	}
	*/
	public boolean isMatched(String userName, String userPass) {
		return name.equals(userName) && pass.equals(userPass);
	}
	public void setTermInfo(int m, int t) {
		month = m;
		Calendar calendar = Calendar.getInstance();
		int nowMonth = calendar.get(Calendar.MONTH);
		int year = (nowMonth > m) ? calendar.get(Calendar.YEAR) + 1 : calendar.get(Calendar.YEAR);
		calendar.set(year,month,1);
		dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		//term = t;
		if(t == 0) {//前半
			//term = 0;
			dayNum = 15;
			return;
		}
		//term = 15;
		/*
		if(m == 1) {
			if(year % 4 == 0) {
				dayNum =  14;
				return;
			}
			dayNum = 13;
			return;
		}
		*/
		if(m == 1 && year % 4 == 0) {
			dayNum = 14;
			return;
		}
		int[] dNum = {16,13,16,15,16,15,16,16,15,16,15,16};
		dayNum = dNum[m];
	}
}