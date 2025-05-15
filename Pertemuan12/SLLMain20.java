public class SLLMain20 {
    public static void main(String[] args) {
        SingleLinkedList20 sll = new SingleLinkedList20();

        Mahasiswa20 mhs1 = new Mahasiswa20("1001", "Nabil", "4D", 3.6);
        Mahasiswa20 mhs2 = new Mahasiswa20("1002", "Rizki", "3C", 3.5);
        Mahasiswa20 mhs3 = new Mahasiswa20("1003", "Samid", "2B", 3.8);
        Mahasiswa20 mhs4 = new Mahasiswa20("1004", "Nugrah", "1A", 4.0);

        sll.addFirst(mhs4);
        sll.addLast(mhs1);
        sll.insertAfter("Nabil", mhs3);
        sll.insertAt(2, mhs2);
        sll.print();

        System.out.println("Data pada indeks 1:");
        sll.getData(1);

        System.out.println("Data mahasiswa bernama Nabil berada di indeks: " + sll.indexOf("Nabil"));

        sll.removeFirst();
        sll.removeLast();
        sll.print();

        sll.removeAt(0);
        sll.print();
    }
}