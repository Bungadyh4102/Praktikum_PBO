package posttest6;

public class BarangSenjata extends BarangAntik implements KoleksiAntik {
    private String jenisSenjata;

    public BarangSenjata(int id, String nama, String asal, int tahun, double harga, String jenisSenjata) {
        super(id, nama, asal, tahun, harga);
        this.jenisSenjata = jenisSenjata;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Jenis Senjata: " + jenisSenjata);
    }

    @Override
    public void infoJenis() {
        System.out.println("Jenis Barang: Senjata kuno yang memiliki nilai sejarah tinggi.");
    }

    @Override
    public void deskripsiKoleksi() {
        System.out.println("Senjata ini digunakan dalam peperangan besar dan memiliki ukiran khas.");
    }

    @Override
    public void nilaiHistoris() {
        System.out.println("Nilai historis: Senjata ini berasal dari abad ke-" + (2025 - tahun) / 100 + ".");
    }
}