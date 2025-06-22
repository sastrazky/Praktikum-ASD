import java.util.LinkedList;
import java.util.Queue;

class SPBUSistem_20 {
    LinkedList<Kendaraan_20> antrianKendaraan = new LinkedList<>();
    Queue<TransaksiPengisian_20> riwayatTransaksi = new LinkedList<>();
    
    void tambahAntrian(String plat, String tipe, String merk) {
        Kendaraan_20 kendaraan_20 = new Kendaraan_20(plat, tipe, merk);
        antrianKendaraan.addLast(kendaraan_20);
        System.out.println(">> Kendaraan " + plat + " masuk ke dalam antrian.");
    }

    void tampilkanAntrian() {
        if (antrianKendaraan.isEmpty()) {
            System.out.println(">> Antrian kosong.");
            return;
        }
        System.out.println("-- Antrian Kendaraan --");
        for (Kendaraan_20 k : antrianKendaraan) {
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
        Kendaraan_20 kendaraanDilayani = antrianKendaraan.removeFirst();
        BBM_20 bbm = new BBM_20(namaBBM, hargaPerLiter);
        TransaksiPengisian_20 transaksi = new TransaksiPengisian_20(kendaraanDilayani, bbm, liter);
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
        for (TransaksiPengisian_20 t : riwayatTransaksi) {
            System.out.println(t.kendaraan.platNomor + ": Rp " + t.totalBayar);
        }
    }
}