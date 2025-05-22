package Pertemuan13;

public class DoubleLinkedList20 {
    Node20 head;
    Node20 tail;

    public DoubleLinkedList20() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa20 data) {
        Node20 newNode = new Node20(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addLast(Mahasiswa20 data) {
        Node20 newNode = new Node20(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAfter(String keyNim, Mahasiswa20 data) {
        Node20 current = head;

        // cari node dgn nim = keyNim
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }

        Node20 newNode = new Node20(data);

        // jika current adalah tail, cukup tambahkan di akhir
        if (current == tail) {
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        } else {
            // Sisipkan di tengah
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        System.out.println("Node berhasil disisipkan setelah NIM " + keyNim);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return;
        }
        Node20 current = head;
        while (current == null) {
            current.data.tampil();
            current = current.next;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }

        System.out.println("Data yang terhapus adalah: ");
        head.data.tampil();

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        System.out.println("Data sudah berhasil dihapus.");
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public Node20 search(String nim) {
        Node20 current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void add(int index, Mahasiswa20 data) {
    if (index < 0) {
        System.out.println("Indeks tidak valid.");
        return;
    }
    if (index == 0) {
        addFirst(data);
        return;
    }

    Node20 newNode = new Node20(data);
    Node20 current = head;
    int count = 0;

    while (current != null && count < index - 1) {
        current = current.next;
        count++;
    }

    if (current == null) {
        System.out.println("Indeks melebihi ukuran list.");
        return;
    }

    newNode.next = current.next;
    newNode.prev = current;
    if (current.next != null) {
        current.next.prev = newNode;
    }
    current.next = newNode;

    if (newNode.next == null) {
        tail = newNode;
    }
}

    public void removeAfter(String keyNim) {
    Node20 current = search(keyNim);
    if (current == null || current.next == null) {
        System.out.println("Tidak ada node setelah NIM " + keyNim);
        return;
    }

    Node20 nodeToRemove = current.next;
    current.next = nodeToRemove.next;
    if (nodeToRemove.next != null) {
        nodeToRemove.next.prev = current;
    } else {
        tail = current;
    }
}

public void remove(int index) {
    if (index < 0 || isEmpty()) {
        System.out.println("Indeks tidak valid atau list kosong.");
        return;
    }
    if (index == 0) {
        removeFirst();
        return;
    }

    Node20 current = head;
    int count = 0;

    while (current != null && count < index) {
        current = current.next;
        count++;
    }

    if (current == null) {
        System.out.println("Indeks melebihi ukuran list.");
        return;
    }

    if (current.next != null) {
        current.next.prev = current.prev;
    } else {
        tail = current.prev;
    }
    if (current.prev != null) {
        current.prev.next = current.next;
    }
}

public void getFirst() {
    if (isEmpty()) {
        System.out.println("List kosong.");
        return;
    }
    head.data.tampil();
}

public void getLast() {
    if (isEmpty()) {
        System.out.println("List kosong.");
        return;
    }
    tail.data.tampil();
}

public void getIndex(int index) {
    if (index < 0 || isEmpty()) {
        System.out.println("Indeks tidak valid atau list kosong.");
        return;
    }

    Node20 current = head;
    int count = 0;

    while (current != null && count < index) {
        current = current.next;
        count++;
    }

    if (current == null) {
        System.out.println("Indeks melebihi ukuran list.");
        return;
    }

    current.data.tampil();
}

public int size() {
    int count = 0;
    Node20 current = head;
    while (current != null) {
        count++;
        current = current.next;
    }
    return count;
}
}
