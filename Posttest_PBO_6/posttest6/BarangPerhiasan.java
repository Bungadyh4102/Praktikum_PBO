package posttest6;

public class BarangPerhiasan extends BarangAntik implements KoleksiAntik {
    private String bahan;

    public BarangPerhiasan(int id, String nama, String asal, int tahun, double harga, String bahan) {
        super(id, nama, asal, tahun, harga);
        this.bahan = bahan;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Bahan Perhiasan: " + bahan);
    }

    @Override
    public void infoJenis() {
        System.out.println("Jenis Barang: Perhiasan antik dengan bahan bernilai tinggi.");
    }

    @Override
    public void deskripsiKoleksi() {
        System.out.println("Perhiasan ini terbuat dari bahan langka dan penuh sejarah.");
    }

    @Override
    public void nilaiHistoris() {
        System.out.println("Nilai historis: Digunakan pada era kerajaan di " + asal + ".");
    }
}