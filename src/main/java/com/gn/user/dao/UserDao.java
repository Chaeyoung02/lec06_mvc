package com.gn.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gn.user.vo.User;

public class UserDao {
	public int createUser(User u, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = "INSERT INTO `user`(`user_id`, `user_pw`, `user_name`) VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUser_id());
			pstmt.setString(2, u.getUser_pw());
			pstmt.setString(3, u.getUser_name());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return result;
//		int result = 0;
//		Statement stmt = null;
//		try {
//			stmt = conn.createStatement();
//			String sql = "INSERT INTO user(user_id, user_pw, user_name) " + "VALUES('" + u.getUser_id() + "','"
//					+ u.getUser_pw() + "','" + u.getUser_name() + "')";
//			result = stmt.executeUpdate(sql);
//			System.out.println("result: "+result);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				stmt.close();
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		}
//
//		return result;
		
	}
//	
	public User loginUser(String id, String pw, Connection conn) {
		int result = 0;
		Statement stmt = null;
		ResultSet rs = null;
		User info =null;
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM `user` WHERE `user_id` = '"+id+"' AND `user_pw`= '"+pw+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				info = new User(rs.getInt("user_no"),
						rs.getString("user_id"),
						rs.getString("user_pw"),
						rs.getString("user_name"));
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return info;
	}
	public int updateUser(User u, String pw, String name, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
		
			String sql1 = "SELECT COUNT(*) AS cnt FROM `user` WHERE user_no = ? AND user_id = ?";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, u.getUser_no());
			pstmt.setString(2, u.getUser_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				result = rs.getInt("cnt");
				//중복되는 아이디가 있는 경우 :-1
				//INSERT과정 중 오류가 발생한 경우 : 0
				//정상 INSERT : 1
			}
			if(result == 1) {
				System.out.println("here");
				String sql2 = "UPDATE `user` SET  user_pw = ?, user_name= ?"
						+ " WHERE user_no = ? AND user_id = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, u.getUser_pw());
				pstmt.setString(2, u.getUser_name());
				pstmt.setInt(3, u.getUser_no());
				pstmt.setString(4, u.getUser_id());
				result = pstmt.executeUpdate();

			}else {
				//insert X
				//중복되는 아이디가 있는 경우 
				result = 0;
			}
			conn.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result ;
	}
	
}
