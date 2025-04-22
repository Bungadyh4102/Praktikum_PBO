public abstract class BarangAntik {
    protected final int id;
    protected String nama;
    protected String asal;
    protected int tahun;
    protected double harga;

    public BarangAntik(int id, String nama, String asal, int tahun, double harga) {
        this.id = id;
        this.nama = nama;
        this.asal = asal;
        this.tahun = tahun;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public final void infoUmum() {
        System.out.println("Informasi Umum: Barang antik bernilai sejarah tinggi.");
    }

    public void display() {
        System.out.println("ID: " + id + " | Nama: " + nama + " | Asal: " + asal + " | Tahun: " + tahun + " | Harga: Rp" + harga);
    }

    public abstract void infoJenis();
}