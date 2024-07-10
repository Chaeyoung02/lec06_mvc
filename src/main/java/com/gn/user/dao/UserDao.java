package com.gn.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
