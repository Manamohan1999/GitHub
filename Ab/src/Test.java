import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static Connection connect() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Mymother1");
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) throws SQLException {
		Connection con=connect();
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("select * from adminlogin");
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
	}
}
