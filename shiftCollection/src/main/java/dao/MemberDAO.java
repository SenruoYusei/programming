package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import model.Member;
import model.MemberSet;
import model.User;


public class MemberDAO {
	private String driverName = "org.mysql.Driver";
	private String jdbcurl = "jdbc:mysql://database-4.clgawijf5hiq.us-east-2.rds.amazonaws.com:3306/database4_forEclipse?user=admin&password=199808Yusei*";
	public Member findMember(User u) {//登録情報に基づき，該当するメンバーがいれば，そのメンバーを返す．
		Member m = null;
		Connection connection = null;
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(jdbcurl);
			String sql = "SELECT ID, NAME, PASS, MNUM, TERM ";
			for(int i = 0;i < 15;i++) {
				sql += "DAY" + i + ",";
			}
			sql += "DAY15";
			sql += " FROM MEMBERS WHERE NAME = ? AND PASS = ?;";
			PreparedStatement pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, u.getName());
			pStmt.setString(2, u.getPass());
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				int month = rs.getInt("MNUM");
				int term = rs.getInt("TERM");
				m = new Member(id, name, pass, month, term);
				String[] sche = new String[m.getDayNum()];
				for(int i = 0;i < sche.length;i++) {
					String d = "DAY" + i;
					sche[i] = rs.getString(d);
				}
				m.setSchedule(sche);
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return m;
	}
	
	
	public MemberSet findAll() {//DB にあるメンバーのアカウントを取得し格納した ArrayList を返す
		MemberSet members = new MemberSet();
		//try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
		try(Connection conn = DriverManager.getConnection(jdbcurl)){	
			String sql = "SELECT ID, NAME, PASS, MNUM, TERM, ";
			for(int i = 0;i < 15;i++) {
				sql += "DAY" + i + ",";
			}
			sql += "DAY15 FROM MEMBERS;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				int month = rs.getInt("MNUM");
				int term = rs.getInt("TERM");
				String[] s = new String[16];
				for(int i = 0;i < 16;i++) {
					s[i] = rs.getString("DAY" + i);
				}
				if(id != 99)members.add(new Member(id, name, pass, month, term,s));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return members;
	}
	
	public int getDayNum(int m, int t) {
		if(m == 1) {
			Date d = new Date();
			ZoneId z = ZoneId.systemDefault();
			LocalDate getld = d.toInstant().atZone(z).toLocalDate();
			int year = getld.getYear();
			if(year % 4 == 0)return 15 + 14 * t;
			return 15 + 13 * t;
		}
		int[] dayNum = {16,16,15,16,15,16,16,15,16,15,16};
		return 15 + dayNum[m] * t;
	}
	public void updatePass(Member m, String newPass) {
		try(Connection conn = DriverManager.getConnection(jdbcurl)){	
			String sql = "UPDATE MEMBERS SET PASS = ? WHERE ID = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, newPass);
			pStmt.setInt(2, m.getId());
			pStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void setTerm(Member m, int month, int term) {
		try(Connection conn = DriverManager.getConnection(jdbcurl)){	
			String sql = "UPDATE MEMBERS SET MNUM = ?, TERM = ? ";
			sql += " WHERE ID = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, month);
			pStmt.setInt(2, term);
			pStmt.setInt(3, m.getId());
			pStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void initializeSchedule(Member m) {
		try(Connection conn = DriverManager.getConnection(jdbcurl)){
			String sql = "UPDATE MEMBERS SET ";
			for(int i = 0;i < 16;i++) {
				sql += "DAY" + i + " = ''";
				if(i != 15)sql += ",";
			}
			sql += " WHERE ID = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, m.getId());
			pStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void insertSchedule(Member m, int pos, String s) {
		try(Connection conn = DriverManager.getConnection(jdbcurl)){	
			String sql = "UPDATE MEMBERS SET DAY" + pos + " = ? WHERE ID = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, s);
			pStmt.setInt(2, m.getId());
			pStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void resetDaySchedule(Member m, int pos) {
		try(Connection conn = DriverManager.getConnection(jdbcurl)){
			String sql = "UPDATE MEMBERS SET DAY" + pos + "='' WHERE ID=?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, m.getId());
			pStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
