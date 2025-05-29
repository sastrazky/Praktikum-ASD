import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SPBUSistem spbu = new SPBUSistem();

        while (true) {
            System.out.println("-- Menu SPBU --");
            System.out.println("1. Tambah Antrian Kendaraan");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Cek Jumlah Antrian Kendaraan");
            System.out.println("4. Layani Kendaraan");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Plat Nomor: ");
                    String plat = scanner.nextLine();
                    System.out.print("Masukkan Jenis Kendaraan: ");
                    String tipe = scanner.nextLine();
                    System.out.print("Masukkan Merk: ");
                    String merk = scanner.nextLine();
                    spbu.tambahAntrian(plat, tipe, merk);
                    break;
                case 2:
                    spbu.tampilkanAntrian();
                    break;
                case 3:
                    spbu.cekJumlahAntrian();
                    break;
                case 4:
                    System.out.print("Masukkan Jenis BBM: ");
                    String namaBBM = scanner.nextLine();
                    System.out.print("Masukkan Harga per liter: ");
                    double hargaPerLiter = scanner.nextDouble();
                    System.out.print("Masukkan Jumlah liter: ");
                    double liter = scanner.nextDouble();
                    scanner.nextLine();
                    spbu.layaniKendaraan(namaBBM, hargaPerLiter, liter);
                    break;
                case 5:
                    spbu.tampilkanRiwayatTransaksi();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan sistem SPBU.");
                    scanner.close();
                    return;
                default:
                    System.out.println(">> Pilihan tidak valid.");
            }
        }
    }
}