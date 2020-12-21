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
	String bacasku;
	String noresi;
	String username; 
	String tgl;
	
	public void tambahjual() {
		System.out.print("Nomor Resi: ");
		this.noresi = input.next();
	}
	
	public void bacadata() {
		try {
			String query = "SELECT * FROM barang";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
            
            System.out.println("\n\t\t\t Detail barang ");
            System.out.println("\t-------------------------------------------------");
            System.out.println("\t| Nama \t| Harga\t |");
            System.out.println("\t-------------------------------------------------");
            
    		String namaa = res.getString("nama");
    		int hargaa = res.getInt("harga_jual");

            System.out.println("\t|"+namaa+"\t\t|"+hargaa+"\t |");
            
            System.out.println("\t-------------------------------------------------");
		} catch(Exception e) {
			
		}
		
	}

}
