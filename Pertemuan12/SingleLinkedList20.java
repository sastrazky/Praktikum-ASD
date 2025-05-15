public class SingleLinkedList20 {
    Node20 head;
    Node20 tail;

    public boolean isEmpty() {
        return (head == null);
    }

    public void print() {
        if (!isEmpty()) {
            Node20 tmp = head;
            System.out.println("Isi Linked List:\t");
            while (tmp != null) {
                tmp.data.tampilInformasi();
                tmp = tmp.next;
            }
            System.out.println(" ");
        } else {
            System.out.println("Linked list kosong");
        }
    }

    public void addFirst(Mahasiswa20 input) {
        Node20 ndInput = new Node20(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    public void addLast(Mahasiswa20 input) {
        Node20 ndInput = new Node20(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    public void insertAfter(String key, Mahasiswa20 input) {
        Node20 ndInput = new Node20(input, null);
        Node20 temp = head;
        while (temp != null) {
            if (temp.data.nama.equalsIgnoreCase(key)) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                if (ndInput.next == null) {
                    tail = ndInput;
                }
                break;
            }
            temp = temp.next;
        }
    }

    public void insertAt(int index, Mahasiswa20 input) {
        if (index < 0) {
            System.out.println("Indeks salah");
        } else if (index == 0) {
            addFirst(input);
        } else {
            Node20 temp = head;
            for (int i = 0; i < index - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp != null) {
                temp.next = new Node20(input, temp.next);
                if (temp.next.next == null) {
                    tail = temp.next;
                }
        }
    }
}
    
    public void getData(int index) {
        if (index < 0) {
            System.out.println("Indeks salah");
            return;
        }
        Node20 tmp = head;
        for (int i = 0; i < index; i++) {
            if (tmp == null) {
                System.out.println("Indeks di luar batas");
                return;
            }
            tmp = tmp.next;
        }
        if (tmp != null) {
            tmp.data.tampilInformasi();
        }
    }

    public int indexOf(String key) {
        Node20 tmp = head;
        int index = 0;
        while (tmp != null) {
            if (tmp.data.nama.equalsIgnoreCase(key)) {
                return index;
            }
            tmp = tmp.next;
            index++;
        }
        return -1;  
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            Node20 temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    public void remove(String key) {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else if (head.data.nama.equalsIgnoreCase(key)) {
            removeFirst();
        } else {
            Node20 temp = head;
            while (temp.next != null && !temp.next.data.nama.equalsIgnoreCase(key)) {
                temp = temp.next;
            }
            if (temp.next != null) {
                temp.next = temp.next.next;
                if (temp.next == null) {
                    tail = temp;
                }
            }
        }
    }

    public void removeAt(int index) {
        if (index < 0) {
            System.out.println("Indeks salah");
        } else if (index == 0) {
            removeFirst();
        } else {
            Node20 temp = head;
            for (int i = 0; i < index - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp != null && temp.next != null) {
                temp.next = temp.next.next;
                if (temp.next == null) {
                    tail = temp;
                }
            }
        }
    }
}