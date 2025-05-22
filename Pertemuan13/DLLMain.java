package Pertemuan13;
import java.util.Scanner;

public class DLLMain {

    public static Mahasiswa20 inputMahasiswa(Scanner scan) {
        System.out.print("NIM: ");
        String nim = scan.nextLine();
        System.out.print("Nama: ");
        String nama = scan.nextLine();
        System.out.print("Kelas: ");
        String kelas = scan.nextLine();
        System.out.print("IPK: ");
        double ipk = scan.nextDouble(); // Perbaikan input IPK
        scan.nextLine(); // Menghindari bug input setelah nextDouble()
        return new Mahasiswa20(nim, nama, kelas, ipk);
    }

    public static void main(String[] args) {
        DoubleLinkedList20 list = new DoubleLinkedList20();
        Scanner scan = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu Double Linked List Mahasiswa");
            System.out.println("1. Tambah di awal");
            System.out.println("2. Tambah di akhir");
            System.out.println("3. Hapus di awal");
            System.out.println("4. Hapus di akhir");
            System.out.println("5. Tampilkan data");
            System.out.println("6. Cari Mahasiswa berdasarkan NIM");
            System.out.println("7. Menyisipkan data setelah NIM tertentu");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1 -> {
                    Mahasiswa20 mhs = inputMahasiswa(scan);
                    list.addFirst(mhs); // Perbaikan, menggunakan addFirst()
                }
                case 2 -> {
                    Mahasiswa20 mhs = inputMahasiswa(scan);
                    list.addLast(mhs);
                }
                // case 3 -> list.removeFirst(); // Aktifkan penghapusan dari awal
                // case 4 -> list.removeLast(); // Aktifkan penghapusan dari akhir
                case 5 -> list.print();
                // case 6 -> {
                //     System.out.print("Masukkan NIM yang dicari: ");
                //     String nim = scan.nextLine();
                //     Node20 found = list.search(nim);
                //     if (found != null) {
                //         System.out.println("Data ditemukan:");
                //         found.data.tampil();
                //     } else {
                //         System.out.println("Data tidak ditemukan.");
                //     }
                // }
                case 7 -> {
                    System.out.print("Masukkan NIM setelah data ingin disisipkan: ");
                    String keyNim = scan.nextLine();
                    Mahasiswa20 mhs = inputMahasiswa(scan);
                    list.insertAfter(keyNim, mhs);
                }
                case 0 -> System.out.println("Keluar dari program.");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
        scan.close();
    }
}