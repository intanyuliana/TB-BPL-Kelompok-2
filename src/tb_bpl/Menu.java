package tb_bpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu {
	static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	static BufferedReader input = new BufferedReader(inputStreamReader);

	public static void menuUtama() {
		System.out.println("\n--------------- Menu Utama ---------------");
		System.out.println("1. Master Barang");
		System.out.println("2. Transaksi");
		System.out.println("3. Laporan");
		System.out.println("");
        System.out.print("PILIHAN> ");

        try {
            int pilihan = Integer.parseInt(input.readLine());
            
            //percabangan
            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    menuBarang();
                    break;
//                case 2:
//                    menuTransaksi();
//                    break;
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
		System.out.println("4. Cari Barang");
		System.out.println("5. Update Data Barang");
		System.out.println("6. Hapus Data Barang");
		System.out.println("7. Menu Utama");
		System.out.println("");
        System.out.print("PILIHAN> ");
		
        try {
            int pilihan = Integer.parseInt(input.readLine());

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
                case 7:
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
