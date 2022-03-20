package model;

import java.util.ArrayList;

public class MemberSet extends ArrayList<Member>{
	String[] schedule;
	public MemberSet() {
	}
	public String[] getSubmittedSchedule(int m, int t) {
		schedule = new String[16];
		Member firstMember = get(0);
		String[] data = firstMember.getAllSchedule();
		for(int i = 0;i < data.length;i++){
			schedule[i] = firstMember.getName() + "," + data[i] + "\n";
		}
		for(int i = 1;i < 30;i++) {
			Member member = (i < size()) ? get(i) : null;
			
			String[] submittedData = (member == null || member.getMonth() != m || member.getTerm() != 15 * t) ? new String[16] : member.getAllSchedule();
			for(int j = 0;j < submittedData.length;j++) {
				schedule[j] += (member == null ? "" : member.getName()) + "," + (submittedData[j] != null ? submittedData[j] : null) + "\n";
			}
		}
		return schedule;
	}
	public String getSchedule(int pos) {
		return schedule[pos];
	}
}
