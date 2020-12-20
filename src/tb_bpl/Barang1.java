package tb_bpl;

import java.sql.*;

public class Barang1 {
	Connection connection = mysqlConnection.dbConnector();
	
	public void tampildetail(){
		try {
			String query = "SELECT * FROM barang";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
            
            System.out.println("\n\t\t\t\t\t Detail Barang ");
            System.out.println("\t-------------------------------------------------------------------------");
            System.out.println("\t| Kode Barang\t| Nama Barang\t| Stock\t| Harga Beli\t| Harga Jual\t|");
            System.out.println("\t-------------------------------------------------------------------------");
            
            //perulangan
            while (res.next()) {
                String sku = res.getString("sku");
                String nama = res.getString("nama");
                int stok = res.getInt("stock");
                int hargabeli = res.getInt("harga_beli");
                int hargajual = res.getInt("harga_jual");
               ;
                
                System.out.println(String.format("\t|%s\t\t|%s\t\t|%d\t|Rp %d\t|Rp %d\t|", sku,nama,stok,hargabeli,hargajual));
            }
            
            System.out.println("\t-------------------------------------------------------------------------\n");
            
            Menu.menuBarang();

        } catch (Exception e) {
            e.printStackTrace();
        }

	}
	
	public void tambahBarang() {
		
		try {
			System.out.println("\n--- Tambah Data Barang ---");
			Barang brg = new Barang();
			brg.barang();
			
			String sku=brg.sku;
			String nama=brg.nama.toUpperCase();
			int stok=brg.stok;
			int hargabeli=brg.hargabeli;
			int hargajual=brg.hargajual;

			String sql = "INSERT INTO barang (sku,nama,stock,harga_beli,harga_jual) VALUES ('%s','%s','%d','%d','%d')";
			sql = String.format(sql,sku,nama,stok,hargabeli,hargajual);
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.execute();
			
    		System.out.println("Data Berhasil Ditambahkan!\n");
    		Menu.menuBarang();
    		
		}
			catch (Exception e) {
				e.printStackTrace();
			}
	
	}
	
	public void restok() {
		try {
			System.out.println("\n--- Restock Barang ---");
			Barang brg = new Barang();
			brg.restok();
			
			String sku = brg.sku;
			int tambah = brg.restok;
			
			String query = "SELECT * FROM barang WHERE sku='%s'";
			query = String.format(query,sku);
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
			res.next();
			int stokawal = res.getInt("stock");
			String nama = res.getString("nama");
			
			int restok = stokawal + tambah;
			
			String sql = "UPDATE barang SET stock='%d' WHERE sku='%s'";
			sql = String.format(sql,restok,sku);
			PreparedStatement pstt = connection.prepareStatement(sql);
			pstt.execute();
			
			System.out.println("Stock " +nama +" Berhasil ditambahkan!!");
    		Menu.menuBarang();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
