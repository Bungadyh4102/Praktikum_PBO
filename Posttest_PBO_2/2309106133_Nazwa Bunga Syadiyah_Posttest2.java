import java.util.ArrayList;
import java.util.Scanner;

class BarangAntik {
    protected int id;
    private String nama;
    private String asal;
    private int tahun;
    private double harga;

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

    public String getAsal() {
        return asal;
    }

    public int getTahun() {
        return tahun;
    }

    public double getHarga() {
        return harga;
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

    public void display() {
        System.out.println("ID: " + id + " | Nama: " + nama + " | Asal: " + asal + " | Tahun: " + tahun + " | Harga: Rp" + harga);
    }
}

public class InventarisBarangAntik {
    private static ArrayList<BarangAntik> daftarBarang = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int idCounter = 1;

    public static void main(String[] args) {
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

    private static void tambahBarang() {
        System.out.print("Masukkan Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Asal Barang: ");
        String asal = scanner.nextLine();
        System.out.print("Masukkan Tahun: ");
        int tahun = scanner.nextInt();
        System.out.print("Masukkan Harga: ");
        double harga = scanner.nextDouble();
        scanner.nextLine(); 
        
        daftarBarang.add(new BarangAntik(idCounter++, nama, asal, tahun, harga));
        System.out.println("Barang berhasil ditambahkan!");
    }

    private static void lihatBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada barang dalam inventaris.");
        } else {
            System.out.println("\n=== DAFTAR BARANG ANTIK ===");
            for (BarangAntik barang : daftarBarang) {
                barang.display();
            }
        }
    }

    private static void updateBarang() {
        System.out.print("Masukkan ID barang yang akan diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        for (BarangAntik barang : daftarBarang) {
            if (barang.getId() == id) {
                System.out.print("Masukkan Nama Baru: ");
                barang.setNama(scanner.nextLine());
                System.out.print("Masukkan Asal Baru: ");
                barang.setAsal(scanner.nextLine());
                System.out.print("Masukkan Tahun Baru: ");
                barang.setTahun(scanner.nextInt());
                System.out.print("Masukkan Harga Baru: ");
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