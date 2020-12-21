package tb_bpl;

import java.sql.*;
import java.util.Scanner;

public class Transaksi1 {
	Connection connection = mysqlConnection.dbConnector();
	Scanner input = new Scanner(System.in);
	
	public void mulaitransaksi(){
		try { 
			Transaksi trk = new Transaksi();
			System.out.print("Username Petugas : ");
			String usr = input.next();
			
			String query = "SELECT * FROM user";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
			
			res.next();
			String user = res.getString("username");
			
			if(user.equals(usr)) {
				trk.tambahjual();
				trk.bacadata();
				//sql yang ke 2
			}else {
				System.out.println("Username Petugas tidak ditemukan!!");
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
//
//	public void tampilbarang() {
//		try {
//			System.out.println("\n\t\t\t\t\t Transaksi ");
//            System.out.println("\t-------------------------------------------------------------------------");
//            System.out.println("\t| Kode Barang\t| Nama Barang\t| Harga\t| Jumlah\t| Jumlah Harga\t|");
//            System.out.println("\t-------------------------------------------------------------------------");
//            System.out.print("\t");
//            
//            while (bacasku != "") {
//            	scanbarang();
//            	System.out.print("\n");
//            }
//            
//            System.out.println("\t-------------------------------------------------------------------------\n");
//            
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	public void scanbarang() {
//		try {
//
//            bacasku = input.next();
//			String query = "SELECT * FROM barang where sku = ?";
//			PreparedStatement pst = connection.prepareStatement(query);
//			ResultSet res = pst.executeQuery();
//			pst.setString(1, bacasku);
//          
//            String nama = res.getString("nama");
//            int hargajual = res.getInt("harga_jual");
//            stok = res.getInt("stock");
//            System.out.print(String.format("\t|%s\t\t|Rp. %d\t|", nama, hargajual));
//            jumlah = input.nextInt();
//            jumlahharga = jumlah * hargajual;
//            System.out.print(jumlahharga);
//            
//            updatestok();
//            
//            totalharga += jumlahharga;
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//	}
//	
//	public void updatestok() {
//		try {
//			stok -= jumlah;
//			String sql = "UPDATE barang SET stok='%d' WHERE sku='%s'";
//			sql = String.format(sql,stok,bacasku);
//			PreparedStatement pstt = connection.prepareStatement(sql);
//			pstt.execute();
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
	
}
