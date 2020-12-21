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

}
