package tb_bpl;

import java.sql.*;
import java.util.Scanner;

public class Transaksi1 {
	Scanner input = new Scanner(System.in);
	Connection connection = mysqlConnection.dbConnector();
	
	String noresi;
	//tanggal
	String username;
	
	public void mulaitransaksi(){
		try {
			
			String query = "SELECT * FROM user";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
			this.username = res.getString("username");
			
			System.out.print("Nomor Resi\t: ");
			this.noresi = input.next();
			
//			blok tanggal
			
			
			
//			insert ke tabel transaksi: noresi, tanggal, username
			
//			String query = "SELECT username from user where username=?";
//			PreparedStatement pst = connection.prepareStatement(query);
//			pst.setString(1, username);
//			ResultSet res = pst.executeQuery();
//			
//			if (!res.next())
//			{
//				
//			}
//			else{
//				System.out.println("Username '" username + "' tidak terdaftar!");
//			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void no(){
		try {
			Transaksi kasir = new Transaksi();
			int id=1;
			
				kasir.scanbarang();
				kasir.tampilbarang();
				kasir.updatestok();
				kasir.hitungtotal();
			} while (kasir.)
			
			
			
//			bikin id
//			baca nomor resi
//			masukin perulangan
//			baca sku
//			trus tampilin barang sesuai sku
//			trus update jumlahnya di stok barang
//			trus itung jumlah * hargajual = totalperbarang
//			tutup perulangan
//			tambahin hargatotal += totalperbarang
//			insert ke tabel transaksi_detail: id, sku, noresi, jumlah, harga
//			id ++

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
