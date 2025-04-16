import java.util.ArrayList;
import java.util.Scanner;

// Superclass
class BarangAntik {
    protected int id;
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

    // Polymorphism Dinamis: Method Overriding
    public void display() {
        System.out.println("ID: " + id + " | Nama: " + nama + " | Asal: " + asal + " | Tahun: " + tahun + " | Harga: Rp" + harga);
    }
}

// Subclass 1
class BarangKeramik extends BarangAntik {
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
}

// Subclass 2
class BarangLukisan extends BarangAntik {
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
}

// Subclass 3
class BarangPerhiasan extends BarangAntik {
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
}

// Subclass 4
class BarangSenjata extends BarangAntik {
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
}

// Main class
public class InventarisBarangAntik {
    private static ArrayList<BarangAntik> daftarBarang = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int idCounter = 1;

    public static void main(String[] args) {
        // Contoh penggunaan overloading
        tambahBarang("keramik", "Vas Kuno", "China", 1800, 15000000, "Bunga Teratai");
        tambahBarang("lukisan", "Panorama Alam", "Indonesia", 1950, 8000000, "I Made Wirata");

        int pilihan;

        do {
            System.out.println("\n=== SISTEM INFORMASI INVENTARIS BARANG ANTIK ===");
            System.out.println("1. Tambah Barang Antik");
            System.out.println("2. Lihat Barang Antik");
            System.out.println("3. Update Barang Antik");
            System.out.println("4. Hapus Barang Antik");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Harap masukkan angka yang valid!");
                scanner.next();
                System.out.print("Pilih menu: ");
            }

            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> tambahBarang();
                case 2 -> lihatBarang();
                case 3 -> updateBarang();
                case 4 -> hapusBarang();
                case 5 -> System.out.println("Terima kasih telah menggunakan sistem.");
                default -> System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 5);
    }

    // Polymorphism Statis: Method Overloading
    private static void tambahBarang(String jenis, String nama, String asal, int tahun, double harga, String tambahanInfo) {
        switch (jenis.toLowerCase()) {
            case "keramik" -> daftarBarang.add(new BarangKeramik(idCounter++, nama, asal, tahun, harga, tambahanInfo));
            case "lukisan" -> daftarBarang.add(new BarangLukisan(idCounter++, nama, asal, tahun, harga, tambahanInfo));
            case "perhiasan" -> daftarBarang.add(new BarangPerhiasan(idCounter++, nama, asal, tahun, harga, tambahanInfo));
            case "senjata" -> daftarBarang.add(new BarangSenjata(idCounter++, nama, asal, tahun, harga, tambahanInfo));
            default -> System.out.println("Jenis tidak valid (dari method overloading).");
        }
    }

    private static void tambahBarang() {
        System.out.println("Pilih Jenis Barang:");
        System.out.println("1. Keramik");
        System.out.println("2. Lukisan");
        System.out.println("3. Perhiasan");
        System.out.println("4. Senjata");
        System.out.print("Pilihan: ");
        int jenis = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Asal Barang: ");
        String asal = scanner.nextLine();
        System.out.print("Tahun: ");
        int tahun = scanner.nextInt();
        System.out.print("Harga: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();

        switch (jenis) {
            case 1 -> {
                System.out.print("Motif Keramik: ");
                String motif = scanner.nextLine();
                daftarBarang.add(new BarangKeramik(idCounter++, nama, asal, tahun, harga, motif));
            }
            case 2 -> {
                System.out.print("Nama Pelukis: ");
                String pelukis = scanner.nextLine();
                daftarBarang.add(new BarangLukisan(idCounter++, nama, asal, tahun, harga, pelukis));
            }
            case 3 -> {
                System.out.print("Bahan Perhiasan: ");
                String bahan = scanner.nextLine();
                daftarBarang.add(new BarangPerhiasan(idCounter++, nama, asal, tahun, harga, bahan));
            }
            case 4 -> {
                System.out.print("Jenis Senjata: ");
                String jenisSenjata = scanner.nextLine();
                daftarBarang.add(new BarangSenjata(idCounter++, nama, asal, tahun, harga, jenisSenjata));
            }
            default -> System.out.println("Jenis tidak valid.");
        }

        System.out.println("Barang berhasil ditambahkan!");
    }

    private static void lihatBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada barang dalam inventaris.");
        } else {
            System.out.println("\n=== DAFTAR BARANG ANTIK ===");
            for (BarangAntik barang : daftarBarang) {
                barang.display(); // Polymorphism dinamis
            }
        }
    }

    private static void updateBarang() {
        System.out.print("Masukkan ID barang yang akan diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (BarangAntik barang : daftarBarang) {
            if (barang.getId() == id) {
                System.out.print("Nama Baru: ");
                barang.setNama(scanner.nextLine());
                System.out.print("Asal Baru: ");
                barang.setAsal(scanner.nextLine());
                System.out.print("Tahun Baru: ");
                barang.setTahun(scanner.nextInt());
                System.out.print("Harga Baru: ");
                barang.setHarga(scanner.nextDouble());
                scanner.nextLine();

                System.out.println("Barang berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Barang dengan ID tersebut tidak ditemukan.");
    }

    private static void hapusBarang() {
        System.out.print("Masukkan ID barang yang akan dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (BarangAntik barang : daftarBarang) {
            if (barang.getId() == id) {
                daftarBarang.remove(barang);
                System.out.println("Barang berhasil dihapus!");
                return;
            }
        }
        System.out.println("Barang dengan ID tersebut tidak ditemukan.");
    }
}