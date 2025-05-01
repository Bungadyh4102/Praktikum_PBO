package posttest6;

public class BarangKeramik extends BarangAntik implements KoleksiAntik {
    private String motif;

    public BarangKeramik(int id, String nama, String asal, int tahun, double harga, String motif) {
        super(id, nama, asal, tahun, harga);
        this.motif = motif;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Motif Keramik: " + motif);
    }

    @Override
    public void infoJenis() {
        System.out.println("Jenis Barang: Keramik dengan motif khas.");
    }

    @Override
    public void deskripsiKoleksi() {
        System.out.println("Keramik ini memiliki keunikan dari motif yang rumit dan indah.");
    }

    @Override
    public void nilaiHistoris() {
        System.out.println("Nilai historis: Keramik berasal dari abad ke-" + (2025 - tahun) / 100 + ".");
    }
}