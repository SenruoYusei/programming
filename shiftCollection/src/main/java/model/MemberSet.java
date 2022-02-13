package model;

import java.util.ArrayList;

public class MemberSet extends ArrayList<Member>{
	String[] schedule;
	public MemberSet() {
	}
	public String[] getSubmittedSchedule(int m, int t) {
		schedule = new String[16];
		Member member = get(0);
		String[] submittedData = (member.getMonth() != m || member.getTermNum() != 15 * t) ? new String[16] : member.getAllSchedule();
		for(int j = 0;j < submittedData.length;j++) {
			schedule[j] += (member == null ? "" : member.getName()) + "," + submittedData[j] + "\n";
		}
		for(int i = 1;i < 30;i++) {
			member = (i < size()) ? get(i) : null;
			
			submittedData = (member == null || member.getMonth() != m || member.getTermNum() != 15 * t) ? new String[16] : member.getAllSchedule();
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
