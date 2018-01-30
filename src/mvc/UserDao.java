package mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
	// UserBiz에서 사용되는 CRUD 함수 정의
	// Connection 정보는 UserBiz 에서 받는다.
	// SQL문을 작성하여 Oracle에 반영한다.
	// 결과를 UserBiz 에 리턴한다.

	public UserDao() {

	}

	public void insert(UserVO user, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertUser);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			int result = pstmt.executeUpdate();
			System.out.println("DAO insert 결과 : " + result);
		} catch (SQLException e) {
			throw e;
		} finally {
			System.out.println("DAO Finally...");
			pstmt.close();
		}
	}
	public void update(UserVO user, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.updateUser);
			pstmt.setString(3, user.getId());
			pstmt.setString(1, user.getPwd());
			pstmt.setString(2, user.getName());
			int result = pstmt.executeUpdate();
			System.out.println("DAO update 결과 : " + result);
		} catch (SQLException e) {
			throw e;
		} finally {
			System.out.println("DAO Finally...");
			pstmt.close();
		}
	}
	public void delete(String id, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteUser);
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();
			System.out.println("DAO delete 결과 : " + result);
		} catch (SQLException e) {
			throw e;
		} finally {
			System.out.println("DAO Finally...");
			pstmt.close();
		}
	}
	public ArrayList<UserVO> selectAll(Connection conn) throws SQLException {
		ArrayList<UserVO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectAllUser);
			result = pstmt.executeQuery();
			while(result.next()) {
				UserVO user = null;  //이전 데이터 초기화. 값을 받아야 하니까.
				String getid = result.getString("ID");
				String pwd = result.getString("PWD");
				String name = result.getString("NAME");
				user = new UserVO(getid, pwd, name);
				list.add(user);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			System.out.println("DAO Finally...");
			if(pstmt != null) pstmt.close();
			if(result != null) result.close();
		}
		return list;
	}
	public UserVO select(String id, Connection conn) throws SQLException {
		UserVO user = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectUser);
			pstmt.setString(1, id);
			result = pstmt.executeQuery();
			result.next(); // 해당 데이터 있는 곳으로 커서(위치)를 옮겨줘야한다.
			String getid = result.getString("ID");
			String pwd = result.getString("PWD");
			String name = result.getString("NAME");
			user = new UserVO(getid, pwd, name);
		} catch (SQLException e) {
			throw e;
		} finally {
			System.out.println("DAO Finally...");
			if(pstmt != null) pstmt.close();
			if(result != null) result.close();
		}
		return user;
	}
	
}
