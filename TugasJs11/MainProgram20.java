import java.util.Scanner;

public class MainProgram20 {
    public static void main(String[] args) {
        AntrianUnitKemahasiswaan20 antrian = new AntrianUnitKemahasiswaan20();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Antrian Unit Kemahasiswaan ===");
            System.out.println("1. Tambahkan mahasiswa ke antrian");
            System.out.println("2. Panggil mahasiswa dari antrian");
            System.out.println("3. Lihat antrian terdepan");
            System.out.println("4. Lihat antrian terakhir");
            System.out.println("5. Tampilkan semua antrian");
            System.out.println("6. Kosongkan antrian");
            System.out.println("7. Hitung jumlah mahasiswa dalam antrian");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama mahasiswa: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIM mahasiswa: ");
                    int nim = scanner.nextInt();
                    antrian.enqueue(nama, nim);
                    break;
                case 2:
                    antrian.dequeue();
                    break;
                case 3:
                    antrian.peekFront();
                    break;
                case 4:
                    antrian.peekRear();
                    break;
                case 5:
                    antrian.displayQueue();
                    break;
                case 6:
                    antrian.clearQueue();
                    break;
                case 7:
                    antrian.countQueue();
                    break;
                case 8:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}