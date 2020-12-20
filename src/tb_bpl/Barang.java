package tb_bpl;

import java.util.Scanner;

public class Barang {
	String sku;
	String nama;
	int stok;
	int hargabeli;
	int hargajual;
	int harga;
	int restok;
	Scanner input = new Scanner(System.in);
	
	public void barang() {
		System.out.print("Kode Barang\t: ");
		this.sku = input.next();
		System.out.print("Nama Barang\t: ");
		this.nama = input.next();
		System.out.print("Jumlah\t: ");
		this.stok = input.nextInt();
		System.out.print("Harga Beli\t: Rp ");
		this.hargabeli = input.nextInt();
		System.out.print("Harga Jual\t: Rp ");
		this.harga = input.nextInt();
		
		if (this.harga<this.hargabeli) {
			System.out.println("Harga Jual lebih kecil dari harga beli!!");
		}else {
			this.hargajual= this.harga;
		}
	}
	
	public void restok() {
		System.out.print("Kode Barang yang akan di Restok\t : ");
		this.sku = input.next();
		System.out.print("Jumlah Penambahan stok\t : ");
		this.restok = input.nextInt();
	}

	public void edit() {
		System.out.print("Kode Barang yang akan di Update\t : ");
		this.sku = input.next();
		System.out.print("Kode Barang\t: ");
		this.sku = input.next();
		System.out.print("Nama Barang\t: ");
		this.nama = input.next();
		System.out.print("Jumlah\t\t: ");
		this.stok = input.nextInt();
		System.out.print("Harga Beli\t: Rp ");
		this.hargabeli = input.nextInt();
		System.out.print("Harga Jual\t: Rp ");
		this.hargajual = input.nextInt();
		
	}

	public void delete() {
		System.out.print("Kode Barang yang akan di Delete\t : ");
		this.sku = input.next();
	}
	
}
