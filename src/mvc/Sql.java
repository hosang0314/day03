package mvc;

public class Sql {
	// static : ������ ���� �ʰ� ���ÿ� ����Ŭ�������� ����Ҽ� �ִ� �����϶� ���
	public static String insertUser = "INSERT INTO TB_USER VALUES (?,?,?)";
	public static String updateUser = "UPDATE TB_USER SET PWD =? , NAME = ? WHERE ID = ?";
	public static String deleteUser = "DELETE FROM TB_USER WHERE ID = ?";
	public static String selectAllUser = "SELECT * FROM TB_USER";
	public static String selectUser = selectAllUser+" WHERE ID = ?";
}
