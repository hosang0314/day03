package mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
	// UserBiz���� ���Ǵ� CRUD �Լ� ����
	// Connection ������ UserBiz ���� �޴´�.
	// SQL���� �ۼ��Ͽ� Oracle�� �ݿ��Ѵ�.
	// ����� UserBiz �� �����Ѵ�.

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
			System.out.println("DAO insert ��� : " + result);
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
			System.out.println("DAO update ��� : " + result);
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
			System.out.println("DAO delete ��� : " + result);
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
				UserVO user = null;  //���� ������ �ʱ�ȭ. ���� �޾ƾ� �ϴϱ�.
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
			result.next(); // �ش� ������ �ִ� ������ Ŀ��(��ġ)�� �Ű�����Ѵ�.
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
