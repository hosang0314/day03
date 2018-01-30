package mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserBiz {
	// Main Application(TEST) ���� ��û�ϴ� ��� ����
	// Connection �����ϰ� Close

	UserDao dao;

	public UserBiz() {
		dao = new UserDao();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle Driver Not Found...");
		}
	}

	public Connection getConnection() {
		// Connection�� ��������� �Ҽ� ����.
		// Connection�� ��������� �Ұ�� �������� Connection�� �۾��� �Ҽ� �ִ� ��Ȳ�� �Ǿ�
		// ���������� �����ؼ� �������� �Ѵ�.

		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "hr";
		String password = "hr";
		try {
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

			}
		}
	}

	public void register(UserVO user) throws Exception {
		Connection conn = getConnection();
		// Connection �ϴٰ� ���ܰ� �߻��� ��� ������ �ƴ϶� ã�� ���� �ʴ�.
		try {
			dao.insert(user, conn);
			dao.insert(user, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
	}

	public void modify(UserVO user) throws Exception {
		Connection conn = getConnection();
		// Connection �ϴٰ� ���ܰ� �߻��� ��� ������ �ƴ϶� ã�� ���� �ʴ�.
		try {
			dao.update(user, conn);
			dao.update(user, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
	}

	public void remove(String id) throws Exception {
		Connection conn = getConnection();
		// Connection �ϴٰ� ���ܰ� �߻��� ��� ������ �ƴ϶� ã�� ���� �ʴ�.
		try {
			dao.delete(id, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
	}

	public ArrayList<UserVO> selectAll() throws Exception {
		Connection conn = getConnection();
		// Connection �ϴٰ� ���ܰ� �߻��� ��� ������ �ƴ϶� ã�� ���� �ʴ�.
		ArrayList<UserVO> list = null; // ���� �����ؼ� ��� list�� �ƴϰ�
		                               // return�� list�� �޴°��̹Ƿ� null�� ����
		try {
			list = dao.selectAll(conn);
		} catch (Exception e) {
			throw e;
		} finally {
			close(conn);
		}
		return list;
	}

	public UserVO select(String id) throws Exception {
		Connection conn = getConnection();
		// Connection �ϴٰ� ���ܰ� �߻��� ��� ������ �ƴ϶� ã�� ���� �ʴ�.
		UserVO user = null;
		try {
			user = dao.select(id, conn);
		}catch(Exception e) {
			throw e;
		}finally {
			close(conn);
		}
		return user;
	}
}
