package tb_bpl;

import java.sql.*;
import javax.swing.*;

public class mysqlConnection {
	Connection conn = null;
	public static Connection dbConnector() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/tb_bpl?serverTimezone=Asia/Jakarta","root","");
			return conn;
			 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
}
