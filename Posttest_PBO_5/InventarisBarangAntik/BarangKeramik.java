public class BarangKeramik extends BarangAntik {
    private String motif;

    public BarangKeramik(int id, String nama, String asal, int tahun, double harga, String motif) {
        super(id, nama, asal, tahun, harga);
        this.motif = motif;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("   Jenis: Keramik | Motif: " + motif);
    }

    @Override
    public void infoJenis() {
        System.out.println("Keramik dengan motif: " + motif);
    }
}