package tb_bpl;

import java.util.Scanner;

public class Menu {
	static Scanner input = new Scanner(System.in);

	public static void menuUtama() {
		System.out.println("\n--------------- Menu Utama ---------------");
		System.out.println("1. Informasi User");
		System.out.println("2. Master Barang");
		System.out.println("3. Transaksi");
		System.out.println("4. Laporan");
		System.out.println("0. Keluar");
		System.out.println("");
        System.out.print("PILIHAN> ");

        try {
            int pilihan = input.nextInt();
            
      
            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
//                case 1:
//                   infouser();
//                    break;
                case 2:
                    menuBarang();
                    break;
                case 3:
                    menuTransaksi();
                    break;
//                case 3:
//                    Laporan();
//                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	public static void menuBarang() {
		System.out.println("\n-------- Master Barang --------");
		System.out.println("1. Detail Barang");
		System.out.println("2. Tambah Data Barang");
		System.out.println("3. Restock Barang");
		System.out.println("5. Update Data Barang");
		System.out.println("6. Hapus Data Barang");
		System.out.println("9. Menu Utama");
		System.out.println("0. Keluar");
		System.out.println("");
        System.out.print("PILIHAN> ");
		
        try {
            int pilihan = input.nextInt();

    		Barang1 barang = new Barang1();
    		
            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                	barang.tampildetail();
                    break;
                case 2:
                    barang.tambahBarang();
                    break;
                case 3:
                   barang.restok();
                    break;
                case 4:
                    barang.update();
                     break;
                case 5:
                    barang.hapus();
                     break;
                case 9:
                	menuUtama();
                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

	}
	
	public static void menuTransaksi() {
		System.out.println("\n-------- Transaksi --------");
		System.out.println("1. Transaksi");
		System.out.println("9. Menu Utama");
		System.out.println("");
        System.out.print("PILIHAN> ");
        
        try {
            int pilihan = input.nextInt();

    		Transaksi transaksi = new Transaksi();
    		
            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                	transaksi.jual();
                    break;
                case 9:
                	menuUtama();
                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
