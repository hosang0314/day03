package mvc;

public class Sql {
	// static : 변경이 되지 않고 동시에 여러클래스에서 사용할수 있는 변수일때 사용
	public static String insertUser = "INSERT INTO TB_USER VALUES (?,?,?)";
	public static String updateUser = "UPDATE TB_USER SET PWD =? , NAME = ? WHERE ID = ?";
	public static String deleteUser = "DELETE FROM TB_USER WHERE ID = ?";
	public static String selectAllUser = "SELECT * FROM TB_USER";
	public static String selectUser = selectAllUser+" WHERE ID = ?";
}
