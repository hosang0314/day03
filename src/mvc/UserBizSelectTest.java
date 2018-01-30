package mvc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class UserBizSelectTest {

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
