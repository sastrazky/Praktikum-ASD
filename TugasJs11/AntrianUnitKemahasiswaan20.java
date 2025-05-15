public class AntrianUnitKemahasiswaan20 {
    public Mahasiswa20 front, rear;
    public int size;

    public AntrianUnitKemahasiswaan20() {
        front = rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(String nama, int nim) {
        Mahasiswa20 baru = new Mahasiswa20(nama, nim);
        if (rear == null) {
            front = rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        size++;
        System.out.println(nama + " telah mendaftar ke antrian.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada yang dipanggil.");
            return;
        }
        System.out.println(front.nama + " telah dipanggil.");
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        Mahasiswa20 temp = front;
        System.out.println("Mahasiswa dalam antrian:");
        while (temp != null) {
            System.out.println("- " + temp.nama + " (NIM: " + temp.nim + ")");
            temp = temp.next;
        }
    }

    public void peekFront() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Mahasiswa terdepan: " + front.nama + " (NIM: " + front.nim + ")");
        }
    }

    public void peekRear() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Mahasiswa terakhir dalam antrian: " + rear.nama + " (NIM: " + rear.nim + ")");
        }
    }

    public void clearQueue() {
        front = rear = null;
        size = 0;
        System.out.println("Antrian telah dikosongkan.");
    }

    public void countQueue() {
        System.out.println("Jumlah mahasiswa dalam antrian: " + size);
    }

}
