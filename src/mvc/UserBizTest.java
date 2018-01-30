package mvc;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class UserBizTest {
	
	UserBiz biz = new UserBiz();
	public UserBizTest() {
	}
	UserDao dao;
	
	@Test
	void testRegister() {
		UserBiz biz = new UserBiz();
		UserVO user = new UserVO("id07", "pwd05", "박말숙");
		try {
			biz.register(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testModify() {
		UserBiz biz = new UserBiz();
		UserVO user = new UserVO("id05", "updatepwd01", "박순자");
		try {
			biz.modify(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Test
	void testRemove() {
		UserBiz biz = new UserBiz();
		String id = "id05";
		try {
			biz.remove(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Test
	void testSelectAll() {
		UserBiz biz = new UserBiz();
		ArrayList<UserVO> list = null;
		System.out.println("--------------------");
		try {
			list = biz.selectAll();
			for(UserVO u :list) {
				System.out.println(u);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("조회중 오류");
			e.printStackTrace();
		}
		System.out.println("--------------------");
	}

	@Test
	void testSelect() {
		UserBiz biz = new UserBiz();
		UserVO user = null;		
		try {
			user = biz.select("id01");
			System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
