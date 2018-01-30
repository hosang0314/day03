package mvc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserBizRegisterTest {

	@Test
	void testRegister() {
		UserBiz biz = new UserBiz();
		UserVO user = new UserVO("id04", "pwd04", "정말숙");
		try {
			biz.register(user);
		} catch (Exception e) {
			System.out.println("입력 오류");
			e.printStackTrace();
		}
	}

}
