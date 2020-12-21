package tb_bpl;

import java.sql.*;
import java.util.Scanner;


import java.util.ArrayList;

public class Barang1 {
	Connection connection = mysqlConnection.dbConnector();
	Scanner input = new Scanner(System.in);
	public void tampildetail(){
		try {
			String query = "SELECT * FROM barang";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
            
            System.out.println("\n\t\t\t\t\t Detail Barang ");
            System.out.println("\t-------------------------------------------------------------------------");
            System.out.println("\t| Kode Barang\t| Nama Barang\t| Stock\t| Harga Beli\t| Harga Jual\t|");
            System.out.println("\t-------------------------------------------------------------------------");
            
            ArrayList<Barang> BRG = new ArrayList<Barang>();
            while (res.next()) {
                
    			BRG.add(new Barang(res.getString("sku"), res.getString("nama"), res.getInt("stock"), res.getInt("harga_beli"), res.getInt("harga_jual")));
                
            }
            for (Barang brg : BRG) {
    			System.out.println("\t|"+brg.sku+"\t\t|"+brg.nama+"\t\t|"+brg.stok+"\t|"+brg.hargabeli+"\t\t|"+brg.hargajual+"\t\t|");
    		}
            
            System.out.println("\t-------------------------------------------------------------------------\n");
            
            Menu.menuBarang();

        } catch (Exception e) {
            System.out.println("Koneksi Gagal!!");
            Menu.menuBarang();
        }

	}
	
	public void tambahBarang() {
		
		try {
			System.out.println("\n--- Tambah Data Barang ---");
			
			System.out.print("Kode Barang\t: ");
			String sku = input.next();
			System.out.print("Nama Barang\t: ");
			String nama = input.next();
			System.out.print("Jumlah\t: ");
			int stok = input.nextInt();
			System.out.print("Harga Beli\t: Rp ");
			int hargabeli = input.nextInt();
			System.out.print("Harga Jual\t: Rp ");
			int hargajual = input.nextInt();
			
			ArrayList<Barang> BRG = new ArrayList<Barang>();
			BRG.add(new Barang(sku, nama.toUpperCase(), stok, hargabeli, hargajual));

			if (hargabeli<hargajual) {
				String sql = "INSERT INTO barang (sku,nama,stock,harga_beli,harga_jual) VALUES (?,?,?,?,?) ";
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setString(1, sku);
				pst.setString(2, nama);
				pst.setInt(3, stok);
				pst.setInt(4, hargabeli);
				pst.setInt(5, hargajual);
				pst.setInt(6, hargabeli);
				pst.setInt(7, hargajual);
				pst.execute();
					
		    	System.out.println("Data Berhasil Ditambahkan!\n");
	    		
			}else {
				System.out.println("Harga Jual Lebih Kecil dari Harga Beli!!\n");
			}
			Menu.menuBarang();
    		
		}
			catch (Exception e) {
				System.out.println("Data Gagal Disimpan!!");
				Menu.menuBarang();
			}
	
	}
	
	public void restok() {
		try {
			System.out.println("\n--- Restock Barang ---");
			
			System.out.print("Kode Barang yang akan ditambah\t: ");
			String sku = input.next();
			System.out.print("Jumlah Penambahan Barang\t: ");
			int tambah = input.nextInt();
			
			String query = "SELECT * FROM barang WHERE sku=?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, sku);
			ResultSet res = pst.executeQuery();
			
			res.next();
			int stokawal = res.getInt("stock");
			String nama = res.getString("nama");
			
			int restok = stokawal + tambah;
			
			String sql = "UPDATE barang SET stock=? WHERE sku=?";
			PreparedStatement pstt = connection.prepareStatement(sql);
			pstt.setInt(1, restok);
			pstt.setString(2, sku);
			pstt.execute();
			
			System.out.println("Stock " +nama +" Berhasil ditambahkan!!");
    		Menu.menuBarang();
			
		}catch (Exception e) {
			System.out.println("Stock Gagal ditambahkan!!");
			Menu.menuBarang();
		}
	}
	
	public void cari() {
		try {
			System.out.println("\n--- Cari Barang ---");
			
			System.out.print("Kode Barang yang akan dicari\t: ");
			String sku = input.next();
			
			String query = "SELECT * FROM barang WHERE sku=?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, sku);
			pst.execute();
			
			System.out.println("Stock " +sku +" Berhasil ditambahkan!!");
    		Menu.menuBarang();
			
		}catch (Exception e) {
			System.out.println("Stock Gagal ditambahkan!!");
			Menu.menuBarang();
		}
		
	}
	public void update() {
		try {
			System.out.println("\n--- Update Barang ---");
			System.out.print("Kode Barang yang akan ditambah\t: ");
			String sku = input.next();
			
			System.out.print("Nama Barang\t: ");
			String nama = input.next();
			System.out.print("Jumlah\t: ");
			int stok = input.nextInt();
			System.out.print("Harga Beli\t: Rp ");
			int hargabeli = input.nextInt();
			System.out.print("Harga Jual\t: Rp ");
			int hargajual = input.nextInt();
		
			
			String sql = "UPDATE barang SET nama='%s',stok='%d',hargabeli='%d',hargajual='%d' WHERE sku='%s'";
			PreparedStatement pstt = connection.prepareStatement(sql);
			pstt.setString(1, nama);
			pstt.setInt(2, stok);
			pstt.setInt(3, hargabeli);
			pstt.setInt(4, hargajual);
			pstt.setString(5, sku);
			pstt.execute();
			
			System.out.println("Stock " + sku +" Berhasil diupdate!!");
    		Menu.menuBarang();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void hapus() {
		 try
         {
			System.out.println("\n--- Delete Barang ---");
			System.out.print("Kode Barang yang akan ditambah\t: ");
			String sku = input.next();

		    String sql="DELETE from barang WHERE sku=?";
		    PreparedStatement pstt = connection.prepareStatement(sql);
			pstt.setString(1,"%"+sku+"%");
			pstt.execute();
			
			System.out.println("Stock " + sku +" Berhasil didelete!!");
    		Menu.menuBarang();
         }
		 catch (Exception e) {
				e.printStackTrace();
			}
	}
}
