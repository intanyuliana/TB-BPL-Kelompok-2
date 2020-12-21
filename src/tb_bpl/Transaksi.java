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

}
