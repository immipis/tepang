import com.tepang.jdbc.MainDAO;

public class test {
	public static void main(String[] args) {
		MainDAO mdao = new MainDAO();
		System.out.println(mdao.addpList("user01"));
	}
}
