package posttest6;

public final class BarangLukisan extends BarangAntik implements KoleksiAntik {
    private String pelukis;

    public BarangLukisan(int id, String nama, String asal, int tahun, double harga, String pelukis) {
        super(id, nama, asal, tahun, harga);
        this.pelukis = pelukis;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Pelukis: " + pelukis);
    }

    @Override
    public void infoJenis() {
        System.out.println("Jenis Barang: Lukisan karya pelukis terkenal.");
    }

    @Override
    public void deskripsiKoleksi() {
        System.out.println("Lukisan ini menggambarkan keindahan alam dan emosi dalam goresan.");
    }

    @Override
    public void nilaiHistoris() {
        System.out.println("Nilai historis: Lukisan dibuat pada tahun " + tahun + " oleh " + pelukis + ".");
    }
}