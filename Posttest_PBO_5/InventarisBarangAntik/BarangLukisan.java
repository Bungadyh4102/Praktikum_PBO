public final class BarangLukisan extends BarangAntik {
    private String pelukis;

    public BarangLukisan(int id, String nama, String asal, int tahun, double harga, String pelukis) {
        super(id, nama, asal, tahun, harga);
        this.pelukis = pelukis;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("   Jenis: Lukisan | Pelukis: " + pelukis);
    }

    @Override
    public void infoJenis() {
        System.out.println("Lukisan karya: " + pelukis);
    }
}