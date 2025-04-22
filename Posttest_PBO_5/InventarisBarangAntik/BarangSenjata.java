public class BarangSenjata extends BarangAntik {
    private String jenisSenjata;

    public BarangSenjata(int id, String nama, String asal, int tahun, double harga, String jenisSenjata) {
        super(id, nama, asal, tahun, harga);
        this.jenisSenjata = jenisSenjata;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("   Jenis: Senjata | Tipe: " + jenisSenjata);
    }

    @Override
    public void infoJenis() {
        System.out.println("Senjata tipe: " + jenisSenjata);
    }
}