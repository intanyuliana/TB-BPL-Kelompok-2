package tb_bpl;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.TreeSet;

public class User1 {
	Connection connection = mysqlConnection.dbConnector();
	Scanner input = new Scanner(System.in);
	
	public void tampilUser() {
		try {
			String query = "SELECT * FROM user";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
            
            System.out.println("\n\t\t\t\t\t Detail User ");
            System.out.println("\t-----------------------------------------------------------------------------------------");
            System.out.println("\t| Username\t\t| Login Terakhir\t| E-mail\t\t|");
            System.out.println("\t-----------------------------------------------------------------------------------------");
            
            TreeSet<User> user = new TreeSet<User>();
            while (res.next()) {
    			user.add(new User(res.getString("username"), res.getString ("login_terakhir"), res.getString("email"), res.getString("pas")));
            }
        
            for (User usr : user) {
            	System.out.println("\t|"+usr.username+"\t\t|"+usr.login+"\t|"+usr.email+"\t\t|");
    		}
            
            System.out.println("\t-----------------------------------------------------------------------------------------");
            
            Menu.menuUser();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void tambahUser() {
		try {
			System.out.println("\n--- Tambah Data User ---");
			
			System.out.print("Username\t: ");
			String user = input.next();
			System.out.print("E-mail\t\t: ");
			String email = input.next();
			System.out.print("Password\t: ");
			String pass = input.next();
			LocalDate time = LocalDate.now();
			DateTimeFormatter frmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String tm =  String.valueOf(frmt.format(time));
			
			TreeSet<User> userr = new TreeSet<User>();
			userr.add(new User(user,tm,email,pass));
	    
			
			String sql = "INSERT INTO user (username,login_terakhir,email,password) VALUES (?,?,?,?) ";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, user);
			pst.setString(2, tm);
			pst.setString(3, email);
			pst.setString(4, pass);
			pst.execute();
					
		    System.out.println("Data Berhasil Ditambahkan!\n");
			Menu.menuUser();
    		
		}
		catch (Exception e) {
            e.printStackTrace();
        }
	}
}
