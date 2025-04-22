public class BarangPerhiasan extends BarangAntik {
    private String bahan;

    public BarangPerhiasan(int id, String nama, String asal, int tahun, double harga, String bahan) {
        super(id, nama, asal, tahun, harga);
        this.bahan = bahan;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("   Jenis: Perhiasan | Bahan: " + bahan);
    }

    @Override
    public void infoJenis() {
        System.out.println("Perhiasan berbahan: " + bahan);
    }
}