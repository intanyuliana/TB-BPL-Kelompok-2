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

			String sql = "INSERT INTO barang (sku,nama,stock,harga_beli,harga_jual) VALUES (?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, sku);
			pst.setString(2, nama);
			pst.setInt(3, stok);
			pst.setInt(4, hargabeli);
			pst.setInt(5, hargajual);
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
			Barang brg = new Barang();
			brg.restok();
			
			String sku = brg.sku;
			int tambah = brg.restok;
			
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
			e.printStackTrace();
		}
	}
	public void update() {
		try {
			System.out.println("\n--- Update Barang ---");
			Barang brg = new Barang();
			brg.edit();
			
			String sku = brg.sku;
			String nama = brg.nama;
			int stok = brg.stok;
			int hargabeli = brg.hargabeli;
			int hargajual = brg.hargajual;
			
			String sql = "UPDATE barang SET nama='%s',stok='%d',hargabeli='%d',hargajual='%d' WHERE sku='%s'";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, nama);
			pst.setInt(2, stok);
			pst.setInt(3, hargabeli);
			pst.setInt(4, hargajual);
			pst.setString(5, sku);
			pst.execute();
			
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
			Barang brg = new Barang();
			brg.delete();
			
			String sku = brg.sku;

		    String sql=String.format("DELETE from barang WHERE sku=%s", sku);
		    PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, sku);
			pst.execute();
			
			System.out.println("Stock " + sku +" Berhasil didelete!!");
    		Menu.menuBarang();
         }
		 catch (Exception e) {
				e.printStackTrace();
			}
	}
}
