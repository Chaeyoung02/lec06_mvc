package com.gn.user.service;

import java.sql.Connection;
import static com.gn.common.sql.JDBCTemplate.getConnection;
import static com.gn.common.sql.JDBCTemplate.close;
import com.gn.user.dao.UserDao;
import com.gn.user.vo.User;

public class UserService {
	
	public int createUser(User u) {
		Connection conn = getConnection();
		int result = new UserDao().createUser(u,conn);
		close(conn);
		return result;
	}
	
	public User loginUser(String id, String pwd) {
		Connection conn = getConnection();
		User u = new UserDao().loginUser(id,pwd,conn);

		close(conn);
		return u;
	}
	public int updateUser(User u) {
		Connection conn = getConnection();
		int result = new UserDao().updateUser(u, conn);
		return result;
	}
}
