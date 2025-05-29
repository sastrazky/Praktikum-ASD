import java.util.LinkedList;
import java.util.Queue;

class SPBUSistem {
    LinkedList<Kendaraan> antrianKendaraan = new LinkedList<>();
    Queue<TransaksiPengisian> riwayatTransaksi = new LinkedList<>();
    
    void tambahAntrian(String plat, String tipe, String merk) {
        Kendaraan kendaraan = new Kendaraan(plat, tipe, merk);
        antrianKendaraan.addLast(kendaraan);
        System.out.println(">> Kendaraan " + plat + " masuk ke dalam antrian.");
    }

    void tampilkanAntrian() {
        if (antrianKendaraan.isEmpty()) {
            System.out.println(">> Antrian kosong.");
            return;
        }
        System.out.println("-- Antrian Kendaraan --");
        for (Kendaraan k : antrianKendaraan) {
            k.tampilkanInformasi();
            System.out.println();
        }
    }

    void cekJumlahAntrian() {
        System.out.println(">> Jumlah kendaraan dalam antrian: " + antrianKendaraan.size());
    }

    void layaniKendaraan(String namaBBM, double hargaPerLiter, double liter) {
        if (antrianKendaraan.isEmpty()) {
            System.out.println(">> Antrian kosong, tidak ada kendaraan untuk dilayani.");
            return;
        }
        Kendaraan kendaraanDilayani = antrianKendaraan.removeFirst();
        BBM bbm = new BBM(namaBBM, hargaPerLiter);
        TransaksiPengisian transaksi = new TransaksiPengisian(kendaraanDilayani, bbm, liter);
        riwayatTransaksi.add(transaksi);
        
        System.out.println(">> Kendaraan " + kendaraanDilayani.platNomor + " telah dilayani.");
        System.out.println(">> Transaksi berhasil dicatat: Rp " + transaksi.totalBayar);
    }

    void tampilkanRiwayatTransaksi() {
        if (riwayatTransaksi.isEmpty()) {
            System.out.println(">> Tidak ada transaksi yang tercatat.");
            return;
        }
        System.out.println("-- Riwayat Transaksi --");
        for (TransaksiPengisian t : riwayatTransaksi) {
            System.out.println(t.kendaraan.platNomor + ": Rp " + t.totalBayar);
        }
    }
}