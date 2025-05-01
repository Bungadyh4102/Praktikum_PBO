package posttest6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InventarisBarangAntik {
    private static ArrayList<BarangAntik> daftarBarang = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int idCounter = 1;
    public static int totalBarang = 0;

    public static void main(String[] args) {
        tambahBarang("keramik", "Vas Kuno", "China", 1800, 15000000, "Bunga Teratai");
        tambahBarang("lukisan", "Panorama Alam", "Indonesia", 1950, 8000000, "I Made Wirata");

        int pilihan = 0;

        do {
            System.out.println("\n=== SISTEM INFORMASI INVENTARIS BARANG ANTIK ===");
            System.out.println("Total Barang: " + totalBarang);
            System.out.println("1. Tambah Barang Antik");
            System.out.println("2. Lihat Barang Antik");
            System.out.println("3. Update Barang Antik");
            System.out.println("4. Hapus Barang Antik");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            try {
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
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Harus berupa angka.");
                scanner.nextLine();
            }
        } while (pilihan != 5);
    }

    private static void tambahBarang(String jenis, String nama, String asal, int tahun, double harga, String tambahanInfo) {
        switch (jenis.toLowerCase()) {
            case "keramik" -> daftarBarang.add(new BarangKeramik(idCounter++, nama, asal, tahun, harga, tambahanInfo));
            case "lukisan" -> daftarBarang.add(new BarangLukisan(idCounter++, nama, asal, tahun, harga, tambahanInfo));
            case "perhiasan" -> daftarBarang.add(new BarangPerhiasan(idCounter++, nama, asal, tahun, harga, tambahanInfo));
            case "senjata" -> daftarBarang.add(new BarangSenjata(idCounter++, nama, asal, tahun, harga, tambahanInfo));
            default -> System.out.println("Jenis tidak valid.");
        }
        totalBarang++;
    }

    private static void tambahBarang() {
        System.out.println("Pilih Jenis Barang:");
        System.out.println("1. Keramik");
        System.out.println("2. Lukisan");
        System.out.println("3. Perhiasan");
        System.out.println("4. Senjata");
        System.out.print("Pilihan: ");

        try {
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

            totalBarang++;
            System.out.println("Barang berhasil ditambahkan!");
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Tambah barang dibatalkan.");
            scanner.nextLine();
        }
    }

    private static void lihatBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada barang dalam inventaris.");
        } else {
            System.out.println("\n=== DAFTAR BARANG ANTIK ===");
            for (BarangAntik barang : daftarBarang) {
                barang.display();
                barang.infoJenis();
                if (barang instanceof KoleksiAntik k) {
                    k.deskripsiKoleksi();
                    k.nilaiHistoris();
                }
                System.out.println("---------------------------------");
            }
        }
    }

    private static void updateBarang() {
        System.out.print("Masukkan ID barang yang ingin diubah: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        BarangAntik barang = daftarBarang.stream().filter(b -> b.getId() == id).findFirst().orElse(null);

        if (barang == null) {
            System.out.println("Barang tidak ditemukan.");
            return;
        }

        System.out.print("Nama baru: ");
        barang.setNama(scanner.nextLine());
        System.out.print("Asal baru: ");
        barang.setAsal(scanner.nextLine());
        System.out.print("Tahun baru: ");
        barang.setTahun(scanner.nextInt());
        System.out.print("Harga baru: ");
        barang.setHarga(scanner.nextDouble());
        scanner.nextLine();

        System.out.println("Barang berhasil diupdate.");
    }

    private static void hapusBarang() {
        System.out.print("Masukkan ID barang yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean removed = daftarBarang.removeIf(b -> b.getId() == id);

        if (removed) {
            totalBarang--;
            System.out.println("Barang berhasil dihapus.");
        } else {
            System.out.println("Barang tidak ditemukan.");
        }
    }
}