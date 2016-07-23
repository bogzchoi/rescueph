package com.hackanation.rescue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBAccess {
	
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	public ArrayList<Member> getMembers(Connection con) throws SQLException {
		ArrayList<Member> memberList = new ArrayList<Member>();
		stmt = con.prepareStatement("SELECT * FROM registers WHERE isverified = ?");
		stmt.setBoolean(1, false);
		rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				Member member = new Member();
				member.setUserid(rs.getInt("userid"));
				member.setPassword(rs.getString("password"));
				member.setFullname(rs.getString("fullname"));
				member.setEmail(rs.getString("email"));
				member.setIsloggedin(rs.getBoolean("isloggedin"));
				member.setIsverified(rs.getBoolean("isverified"));
				member.setContactnumber(rs.getString("contactnumber"));
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		    stmt.close();
		    rs.close();
		}
		return memberList;
	}

	public Member getMember(Connection con, int id) throws SQLException {
		Member member = new Member();
		try {
			stmt = con.prepareStatement("SELECT * FROM registers WHERE userid = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();		

			while(rs.next()) {
				member.setFullname(rs.getString("fullname"));
				member.setUserid(rs.getInt("userid"));
				member.setPassword(rs.getString("password"));
				member.setEmail(rs.getString("email"));
				member.setIsloggedin(rs.getBoolean("isloggedin"));
				member.setIsverified(rs.getBoolean("isverified"));
				member.setContactnumber(rs.getString("contactnumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	public Member addMember(Connection con, Member m) throws SQLException {
		String query = "INSERT INTO registers (userid, fullname, email, password, isloggedin, isverified, contactnumber) VALUES(?,?,?,?,?,?,?)";
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, m.getUserid());
			stmt.setString(2, m.getFullname());
			stmt.setString(3, m.getEmail());
			stmt.setString(4, m.getPassword());
			stmt.setBoolean(5, m.isIsloggedin());
			stmt.setBoolean(6, m.isIsverified());
			stmt.setString(7, m.getContactnumber());
			stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		    stmt.close();
		    rs.close();
		}
		return m;
	}
	
	public void deleteMember(Connection con, int id) throws SQLException {
		try {
			stmt = con.prepareStatement("DELETE FROM registers WHERE userid = ?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		    stmt.close();
		    rs.close();
		}
	}
	
	public Member updateMember(Connection con, Member m) throws SQLException {
		try {
			stmt = con.prepareStatement("UPDATE registers SET isverified = ? WHERE userid = ?");
			stmt.setBoolean(1, m.isIsverified());
			stmt.setInt(2, m.getUserid());
			stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
		    stmt.close();
		    rs.close();
		}
		
		return getMember(con, m.getUserid());
	}

	public List<Messages> getMessages(Connection con) throws SQLException {
		ArrayList<Messages> msgList = new ArrayList<Messages>();
		stmt = con.prepareStatement("SELECT * FROM messages");
		rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				Messages msgs = new Messages();
				msgs.setUserid(rs.getInt("userid"));
				msgs.setFullname(rs.getString("fullname"));
				msgs.setMessageid(rs.getInt("messageid"));
				msgs.setMessage(rs.getString("message"));
				msgs.setXcoord(rs.getDouble("xcoord"));
				msgs.setYcoord(rs.getDouble("ycoord"));
				msgs.setStatus(rs.getInt("status"));
				msgList.add(msgs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		    stmt.close();
		    rs.close();
		}
		return msgList;
	}

	public Messages getMessage(Connection con, int id) throws SQLException {
		Messages msg = new Messages();
		try {
			stmt = con.prepareStatement("SELECT * FROM messages WHERE messageid = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();		

			while(rs.next()) {
				msg.setUserid(rs.getInt("userid"));
				msg.setFullname(rs.getString("fullname"));
				msg.setMessageid(rs.getInt("messageid"));
				msg.setMessage(rs.getString("message"));
				msg.setXcoord(rs.getLong("xcoord"));
				msg.setYcoord(rs.getLong("ycoord"));
				msg.setStatus(rs.getInt("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
		    rs.close();
		    stmt.close();
			con.close();
		}
		return msg;
	}
	
	public Messages getMessageByUserId(Connection con, int id) throws SQLException {
		Messages msg = new Messages();
		try {
			stmt = con.prepareStatement("SELECT * FROM messages WHERE userid = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();		

			while(rs.next()) {
				msg.setUserid(rs.getInt("userid"));
				msg.setFullname(rs.getString("fullname"));
				msg.setMessage(rs.getString("message"));
				msg.setMessageid(rs.getInt("messageid"));
				msg.setXcoord(rs.getDouble("xcoord"));
				msg.setYcoord(rs.getDouble("ycoord"));
				msg.setStatus(rs.getInt("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    rs.close();
		    stmt.close();
			con.close();
		}
	    return msg;
		
	}

	public Messages addMessage(Connection con, Messages m) throws SQLException {
		String query = "INSERT INTO messages (userid, fullname, message, xcoord, ycoord, status) VALUES(?,?,?,?,?,?)";
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, m.getUserid());
			stmt.setString(2, m.getFullname());
			stmt.setString(3, m.getMessage());
			stmt.setDouble(4, m.getXcoord());
			stmt.setDouble(5, m.getYcoord());
			stmt.setInt(6, m.getStatus());
			stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
		    if(rs != null) rs.close();
		    if(stmt != null) stmt.close();
		    if(con != null) stmt.close();
		}
		return m;
	}

	public void deleteMessage(Connection con, int id) throws SQLException {
		try {
			stmt = con.prepareStatement("DELETE FROM messages WHERE userid = ?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
		    rs.close();
		    stmt.close();
			con.close();
		}
	}

	public Messages updateMessage(Connection con, Messages msg) throws SQLException {
		try {
			stmt = con.prepareStatement("UPDATE messages SET status = ? WHERE messageid = ? AND userid = ?");
			stmt.setInt(1, msg.getStatus());
			stmt.setInt(2, msg.getMessageid());
			stmt.setInt(3, msg.getUserid());
			stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
		    stmt.close();
		    rs.close();
		}
		
		return getMessage(con, msg.getMessageid());
	}
	
	public Member getMemberByEmail(Connection con, String email, String password) throws SQLException {
		Member member = new Member();
		try {
			stmt = con.prepareStatement("SELECT * FROM registers WHERE email = ?");
			stmt.setString(1, email);
			rs = stmt.executeQuery();

			while(rs.next()) {
				System.out.println("email fr db: " + rs.getString("email"));
				if(rs.getString("password").equals(password)) {
					member.setPassword(password);
					member.setIsloggedin(true);
				}
				member.setFullname(rs.getString("fullname"));
				member.setUserid(rs.getInt("userid"));
				member.setPassword(rs.getString("password"));
				member.setEmail(rs.getString("email"));
				member.setContactnumber(rs.getString("contactnumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    rs.close();
		    stmt.close();
			con.close();
		}
	    return member;
	}	

}
