package TugasJobsheet10;

import java.util.Scanner;
public class MainKRS20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianKRS20 antrian = new AntrianKRS20(10);
        final int KAPASITAS_DPA = 30;
        int pilihan;

        do {
            System.out.println("\n=== MENU ANTRIAN KRS ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Panggil 2 Mahasiswa untuk KRS");
            System.out.println("3. Lihat Mahasiswa Terdepan");
            System.out.println("4. Lihat Mahasiswa Terakhir");
            System.out.println("5. Tampilkan Semua Antrian");
            System.out.println("6. Tampilkan 2 Terdepan");
            System.out.println("7. Cek Antrian Kosong");
            System.out.println("8. Cek Antrian Penuh");
            System.out.println("9. Kosongkan Antrian");
            System.out.println("10. Cetak Jumlah dalam Antrian");
            System.out.println("11. Cetak Jumlah yang Sudah Dilayani");
            System.out.println("12. Cetak Sisa Mahasiswa untuk DPA");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi : ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();
                    MahasiswaKRS20 mhs = new MahasiswaKRS20(nim, nama, prodi, kelas);
                    antrian.tambahAntrian(mhs);
                    break;
                case 2:
                    antrian.panggilUntukKRS();
                    break;
                case 3:
                    antrian.lihatTerdepan();
                    break;
                case 4:
                    antrian.lihatAkhir();
                    break;
                case 5:
                    antrian.tampilkanSemua();
                    break;
                case 6:
                    antrian.tampilkanDuaTerdepan();
                    break;
                case 7:
                    System.out.println("Antrian kosong? " + antrian.isEmpty());
                    break;
                case 8:
                    System.out.println("Antrian penuh? " + antrian.isFull());
                    break;
                case 9:
                    antrian.clear();
                    break;
                case 10:
                    System.out.println("Jumlah mahasiswa dalam antrian: " + antrian.getJumlahAntrian());
                    break;
                case 11:
                    System.out.println("Jumlah mahasiswa yang sudah KRS: " + antrian.getJumlahDilayani());
                    break;
                case 12:
                    System.out.println("Sisa mahasiswa untuk DPA (kapasitas 30): " + antrian.getSisaUntukDPA(KAPASITAS_DPA));
                    break;
                case 0:
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 0);

        sc.close();
    }
}
