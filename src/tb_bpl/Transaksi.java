package tb_bpl;

import java.sql.*;
import java.util.Scanner;

public class Transaksi {
	Scanner input = new Scanner(System.in);
	Connection connection = mysqlConnection.dbConnector();
	int jumlah;
	int jumlahharga;
	int totalharga;
	int stok; 
	int harga;
	String bacasku;
	String noresi;
	String username; 
	String tgl;
	String namabarang;
	
	public void tambahjual() {
		System.out.print("Nomor Resi\t: ");
		this.noresi = input.next();
	}
	
	public void bacabarcode() {
		System.out.print("SKU\t\t: ");
		this.bacasku = input.next();
	}
	
	public void tambahjumlah() {
		this.jumlah = input.nextInt();
		
	}

	public void masukindata() {
		try {
			System.out.println("\n--- Detail Transaksi ---");
			
			System.out.print("Nomor\t\t: ");
			int id = input.nextInt();
			System.out.print("Kode Barang\t: ");
			String sku = input.next();
			System.out.print("Nama Barang\t: ");
			
			String sql = "INSERT INTO transaksi_detail (id,sku,noresi,jumlah,harga) VALUES (?,?,?,?,?) ";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, sku);
			pst.setString(3, noresi);
			pst.setInt(4, jumlahharga);
			pst.setInt(5, harga);
			pst.execute();
			
			if(sku!="") {
			masukindata();
			}
		}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void tampiltransaksi() {
		try {
			String query = "SELECT * FROM transaksi";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
            
            System.out.println("\n\t\t\t\t\t Tabel Transaksi ");
            System.out.println("\t--------------------------------------------------------");
            System.out.println("\t| Nomor Resi \t| Tanggal\t\t| Username\t|");
            System.out.println("\t--------------------------------------------------------");
            
            while (res.next()) {
                
    			String noresi = res.getString("noresi");
    			Date tanggal = res.getDate("tanggal");
    			String username = res.getString("username");
 
    			System.out.println("\t|"+noresi+"\t|"+tanggal+"\t\t|"+username+"\t|");
    		}
            
            System.out.println("\t--------------------------------------------------------\n");

        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
}
