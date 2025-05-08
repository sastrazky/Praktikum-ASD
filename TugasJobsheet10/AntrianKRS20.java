package TugasJobsheet10;

public class AntrianKRS20 {
    MahasiswaKRS20[] data;
    int front, rear, size, max;
    int totalDilayani = 0;

    public AntrianKRS20(int max) {
        this.max = max;
        data = new MahasiswaKRS20[max];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Antrian dikosongkan.");
    }

    public void tambahAntrian(MahasiswaKRS20 mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh.");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " masuk antrian.");
    }

    public void panggilUntukKRS() {
        if (size < 2) {
            System.out.println("Tidak cukup mahasiswa untuk dipanggil (butuh 2).");
            return;
        }
        System.out.println("Memanggil 2 mahasiswa untuk proses KRS:");
        for (int i = 0; i < 2; i++) {
            MahasiswaKRS20 mhs = data[front];
            mhs.tampilkanData();
            front = (front + 1) % max;
            size--;
            totalDilayani++;
        }
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Seluruh Mahasiswa dalam Antrian:");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    public void tampilkanDuaTerdepan() {
        if (size < 1) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Dua Mahasiswa Terdepan:");
            for (int i = 0; i < Math.min(2, size); i++) {
                int index = (front + i) % max;
                data[index].tampilkanData();
            }
        }
    }

    public void lihatTerdepan() {
        if (!isEmpty()) {
            System.out.print("Mahasiswa terdepan: ");
            data[front].tampilkanData();
        } else {
            System.out.println("Antrian kosong.");
        }
    }

    public void lihatAkhir() {
        if (!isEmpty()) {
            System.out.print("Mahasiswa paling akhir: ");
            data[rear].tampilkanData();
        } else {
            System.out.println("Antrian kosong.");
        }
    }

    public int getJumlahAntrian() {
        return size;
    }

    public int getJumlahDilayani() {
        return totalDilayani * 2;
    }

    public int getSisaUntukDPA(int kapasitasDPA) {
        return kapasitasDPA - getJumlahDilayani();
    }
}
