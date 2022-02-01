package model;

import java.util.ArrayList;

public class MemberSet extends ArrayList<Member>{
	String[] schedule;
	public MemberSet() {
	}
	public String[] getSubmittedSchedule(int m, int t) {
		schedule = new String[16];
		for(int i = 0;i < 30;i++) {
			Member member = (i < size()) ? get(i) : null;
			
			String[] submittedData = (member == null || member.getMonth() != m || member.getTermNum() != 15 * t) ? new String[16] : member.getAllSchedule();
			for(int j = 0;j < submittedData.length;j++) {
				schedule[j] += (member == null ? "" : member.getName()) + "," + submittedData[j] + "\n";
			}
		}
		return schedule;
	}
	public String getSchedule(int pos) {
		return schedule[pos];
	}
}
