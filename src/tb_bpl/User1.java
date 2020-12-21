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
            
            System.out.println("\n\t\t\t Detail User ");
            System.out.println("\t-------------------------------------------------");
            System.out.println("\t| Username\t| Login Terakhir | E-mail\t|");
            System.out.println("\t-------------------------------------------------");
            
            TreeSet<User> user = new TreeSet<User>();
            while (res.next()) {
    			user.add(new User(res.getString("username"), res.getString ("login_terakhir"), res.getString("email"), res.getString("password")));
            }
        
            for (User usr : user) {
            	System.out.println("\t|"+usr.username+"\t\t|"+usr.login+"\t |"+usr.email+"\t\t|");
    		}
            
            System.out.println("\t-------------------------------------------------");
            
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
	
	public void updateUser() {
		try {
			System.out.println("\n--- Update User ---");
			
			System.out.print("Username yang akan di ubah\t: ");
			String user = input.next();
			System.out.print("Password Awal\t: ");
			String pass = input.next();
			LocalDate time = LocalDate.now();
			DateTimeFormatter frmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String tm =  String.valueOf(frmt.format(time));
			
			String queryy = "SELECT * FROM user WHERE username=?";
			PreparedStatement pst = connection.prepareStatement(queryy);
			pst.setString(1, user);
			ResultSet res = pst.executeQuery();
			
			res.next();
			String pw = res.getString("password");
		
			if (pw.equals(pass)== true) {
				System.out.print("Password Baru\t: ");
				String pas = input.next();
				System.out.print("E-mail\t\t: ");
				String email = input.next();
				TreeSet<User> userr = new TreeSet<User>();
				userr.add(new User(user,tm,email,pas));
		    
				String sql = "UPDATE user SET login_terakhir=?, email=?, password=? WHERE username=? ";
				PreparedStatement psst = connection.prepareStatement(sql);
				psst.setString(1, tm);
				psst.setString(2, email);
				psst.setString(3, pas);
				psst.setString(4, user);
				psst.execute();
				System.out.println("Update Data User Berhasil!!");
			}
			else {
				System.out.println("Password Lama Anda Salah!!");
			}
			Menu.menuUser();
			
		}catch (Exception e) {
			e.printStackTrace();
			Menu.menuUser();
		}
		
		
	}
	public void cariUser() {
		try {
			System.out.println("\n--- Cari Barang ---");
			
			System.out.print("Username yang akan dicari\t: ");
			String username = input.next();
			
			String query = "SELECT * FROM user WHERE username=?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, "%"+username+"%");
			pst.execute();
			
    		Menu.menuBarang();
			
		}catch (Exception e) {
			System.out.println("Data Tidak ditemukan!!");
			Menu.menuBarang();
		}
		
	}

	public void hapusUser() {
		 try
         {
			System.out.println("\n--- Delete Barang ---");
			System.out.print("Kode Barang yang akan dihapus\t: ");
			String username = input.next();

		    String sql="DELETE from user WHERE username=?";
		    PreparedStatement pstt = connection.prepareStatement(sql);
			pstt.setString(1,username);
			pstt.execute();
			
			System.out.println("Stock " + username +" Berhasil didelete!!");
    		Menu.menuBarang();
         }
		 catch (Exception e) {
				e.printStackTrace();
			}
	}
		
}
