package tb_bpl;

import java.sql.*;
import java.util.Scanner;

public class Transaksi {
	Connection connection = mysqlConnection.dbConnector();
	Scanner input = new Scanner(System.in);
	String skuT;
	String namaT;
	int stokT;
	int hargajualT;
	
	public void tampilTransaksi() {
		try {
			
			int barcode = input.nextInt();
			
			String query = "SELECT * FROM barang WHERE sku='%s'";
			String sql = String.format(query,barcode);
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet res = pst.executeQuery();
            
            while (res.next()) {
                this.skuT = res.getString("sku");
                this.namaT = res.getString("nama");
                this.stokT = res.getInt("stock");
                this.hargajualT = res.getInt("harga_jual");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
	}	
	
	public void jual() {
		
	}

	

}


