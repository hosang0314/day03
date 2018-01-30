package mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserBiz {
	// Main Application(TEST) 에서 요청하는 기능 구현
	// Connection 생성하고 Close

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
		// Connection은 멤버변수로 할수 없다.
		// Connection을 멤버변수로 할경우 여러개의 Connection이 작업을 할수 있는 상황이 되어
		// 지역변수로 선언해서 사용해줘야 한다.

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
		// Connection 하다가 예외가 발생할 경우 오류가 아니라서 찾기 쉽지 않다.
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
		// Connection 하다가 예외가 발생할 경우 오류가 아니라서 찾기 쉽지 않다.
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
		// Connection 하다가 예외가 발생할 경우 오류가 아니라서 찾기 쉽지 않다.
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
		// Connection 하다가 예외가 발생할 경우 오류가 아니라서 찾기 쉽지 않다.
		ArrayList<UserVO> list = null; // 새로 생성해서 담는 list가 아니고
		                               // return된 list를 받는것이므로 null로 선언
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
		// Connection 하다가 예외가 발생할 경우 오류가 아니라서 찾기 쉽지 않다.
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
