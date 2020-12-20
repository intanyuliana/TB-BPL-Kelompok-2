package tb_bpl;

import java.sql.*;
import java.util.Scanner;

public class Transaksi {
	Scanner input = new Scanner(System.in);
	Connection connection = mysqlConnection.dbConnector();
	int jumlah;
	int jumlahharga;
	int totalharga;
	String bacasku;
	String noresi;
	String username;
//	tanggal
	
	public void mulaitransaksi(){
		try {
			
			String query = "SELECT * FROM user";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
			this.username = res.getString("username");
			
			System.out.print("Nomor Resi\t: ");
			this.noresi = input.next();
			
//			blok tanggal
			
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
	

	public void tampilbarang() {
		try {
			System.out.println("\n\t\t\t\t\t Transaksi ");
            System.out.println("\t-------------------------------------------------------------------------");
            System.out.println("\t| Kode Barang\t| Nama Barang\t| Harga\t| Jumlah\t| Jumlah Harga\t|");
            System.out.println("\t-------------------------------------------------------------------------");
            System.out.print("\t");
            
            do {
            	scanbarang();
            	System.out.print("\n");
            } while (bacasku != "");
            
            System.out.println("\t-------------------------------------------------------------------------\n");
            
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void scanbarang() {
		try {

            bacasku = input.next();
			String query = "SELECT * FROM barang where sku = ?";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
			pst.setString(1, bacasku);
          
            String nama = res.getString("nama");
            int hargajual = res.getInt("harga_jual");
            System.out.print(String.format("\t|%s\t\t|Rp. %d\t|", nama, hargajual));
            jumlah = input.nextInt();
            jumlahharga = jumlah * hargajual;
            System.out.print(jumlahharga);
            
            
            
            totalharga += jumlahharga;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
