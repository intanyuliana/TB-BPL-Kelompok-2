package tb_bpl;

public class Barang {
	String sku;
	String nama;
	int stok;
	int hargabeli;
	int hargajual;
	
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}

	public int getHargabeli() {
		return hargabeli;
	}

	public void setHargabeli(int hargabeli) {
		this.hargabeli = hargabeli;
	}

	public int getHargajual() {
		return hargajual;
	}

	public void setHargajual(int hargajual) {
			this.hargajual = hargajual;
	}

	public Barang(String sku, String nama, Integer stok, Integer hargabeli, Integer hargajual) {
		setSku(sku);
		setNama(nama);
		setStok(stok);
		setHargabeli(hargabeli);
		setHargajual(hargajual);
	}
}
