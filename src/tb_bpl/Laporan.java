package tb_bpl;
import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner; 



public class Laporan {
	Connection connection = mysqlConnection.dbConnector();

	Scanner scn = new Scanner(System.in);

	public void laporan() {
		try {

			int hitung = 0;
			int penjualan = 0;
			String bln;
			int cek1 = 0;
			String bulan = "";

			do {
				System.out.println("\n||Laporan Penjualan Perbulan");
				System.out.print("\nSilakan Inputkan Bulannya (1-12) : ");
				bln = scn.next();

				switch (bln) {

				case "1":
					cek1 = 1;
					bulan = "Januari";
					break;

				case "2":
					cek1 = 1;
					bulan = "Februari";
					break;

				case "3":
					cek1 = 1;
					bulan = "Maret";
					break;

				case "4":
					cek1 = 1;
					bulan = "April";
					break;

				case "5":
					cek1 = 1;
					bulan = "Mei";
					break;

				case "6":
					cek1 = 1;
					bulan = "Juni";
					break;

				case "7":
					cek1 = 1;
					bulan = "Juli";
					break;

				case "8":
					cek1 = 1;
					bulan = "Agustus";
					break;

				case "9":
					cek1 = 1;
					bulan = "September";
					break;

				case "10":
					cek1 = 1;
					bulan = "Oktober";
					break;

				case "11":
					cek1 = 1;
					bulan = "November";
					break;

				case "12":
					cek1 = 1;
					bulan = "Desember";
					break;

				default:
					cek1 = 0;
					System.out.print("\n---Input Salah!!\n");
					break;
				}

			} while (cek1 == 0);


			String query = "SELECT detail_transaksi.id, transaksi.tanggal, detail_transaksi.sku, detail_transaksi.noresi, transaksi.username, detail_transaksi.jumlah, detail_transaksi.harga\r\n"
					+ "	FROM detail_transaksi,transaksi\r\n"
					+ "	WHERE transaksi.noresi = detail_transaksi.noresi AND EXTRACT (MONTH FROM tanggal) = " + bln +" ORDER BY tanggal ASC";

			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();

			System.out.println("\n||Laporan Penjualan Bulan " + bulan);
			System.out.println("\nid\ttanggal\t\tsku\tnoresi\tusername\tjumlah\tharga");

			while (res.next()) {

				System.out.print("\n" + res.getInt("id") + "\t");
				System.out.print(res.getDate("tanggal") + "\t");
				System.out.print(res.getString("sku") + "\t");
				System.out.print(res.getString("noresi") + "\t");
				System.out.print(res.getString("username") + "\t\t");
				System.out.print(res.getInt("jumlah") + "\t");
				System.out.print("Rp." + res.getInt("harga") + "\t");

				hitung = hitung + 1;
				penjualan = penjualan + res.getInt("harga");
			}

			System.out.println(
					"\n\nBanyak Tranksaksi Penjualan yang Terjadi Pada Bulan ini Adalah " + hitung + " Tranksaksi");
			System.out.println("Total Penjualan Pada Bulan ini Adalah : Rp." + penjualan);

		} catch (SQLException e) {

			System.out.println("\"\\nInputan Gagal!!\"");
		}
		
	}

	public void keuntungan() {
		try {

			int hitung =0;
			int keuntungan;
			int laba = 0;
			int cek1 = 0;
			String bulan = "";
			String bln;

			do {
				System.out.println("\n||Laporan Keuntungan Perbulan");
				System.out.print("\nSilakan Inputkan Bulannya (1-12) : ");
				bln = scn.next();

				switch (bln) {

				case "1":
					cek1 = 1;
					bulan = "Januari";
					break;

				case "2":
					cek1 = 1;
					bulan = "Februari";
					break;

				case "3":
					cek1 = 1;
					bulan = "Maret";
					break;

				case "4":
					cek1 = 1;
					bulan = "April";
					break;

				case "5":
					cek1 = 1;
					bulan = "Mei";
					break;

				case "6":
					cek1 = 1;
					bulan = "Juni";
					break;

				case "7":
					cek1 = 1;
					bulan = "Juli";
					break;

				case "8":
					cek1 = 1;
					bulan = "Agustus";
					break;

				case "9":
					cek1 = 1;
					bulan = "September";
					break;

				case "10":
					cek1 = 1;
					bulan = "Oktober";
					break;

				case "11":
					cek1 = 1;
					bulan = "November";
					break;

				case "12":
					cek1 = 1;
					bulan = "Desember";
					break;

				default:
					cek1 = 0;
					System.out.print("\n---Input Salah!! Ulangi---\n");
					break;
				}
			} while (cek1 == 0);


			String query = "SELECT detail_transaksi.id, transaksi.tanggal, detail_transaksi.noresi, detail_transaksi.sku, barang.nama, detail_transaksi.jumlah, barang.harga_beli, barang.harga_jual\r\n"
					+ "	FROM detail_transaksi,transaksi,barang\r\n"
					+ "	WHERE transaksi.noresi = detail_transaksi.noresi AND detail_transaksi.sku = barang.sku AND EXTRACT (MONTH FROM tanggal) = "
					+ bln + " ORDER BY tanggal ASC";
			
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();

			System.out.println("\n||Laporan Keuntungan Bulan " + bulan);
			System.out.println("\nid\ttanggal\t\tnoresi\tsku\tnamabarang\tjumlah\thargabeli\thargajual\tkeuntungan");

			while (res.next()) {

				System.out.print("\n" + res.getInt("id") + "\t");
				System.out.print(res.getDate("tanggal") + "\t");
				System.out.print(res.getString("noresi") + "\t");
				System.out.print(res.getString("sku") + "\t");
				System.out.print(res.getString("nama") + "\t\t");
				System.out.print(res.getInt("jumlah") + "\t");
				System.out.print("Rp." + res.getInt("harga_beli") + "\t\t");
				System.out.print("Rp." + res.getInt("harga_jual") + "\t\t");

				keuntungan = (res.getInt("jumlah")) * (res.getInt("harga_jual") - res.getInt("harga_beli"));
				hitung = hitung + 1;
				
				System.out.print("Rp." + keuntungan);

				laba = laba + keuntungan;
			}

			System.out.println(
					"\n\nBanyak Tranksaksi Penjualan yang Terjadi Pada Bulan ini Adalah " + hitung + " Tranksaksi");
			System.out.println("Total Keuntungan Pada Bulan ini Adalah : Rp." + laba);

		} catch (SQLException e) {

			System.out.println("\nInputan Gagal!!");
		}
	}

}


