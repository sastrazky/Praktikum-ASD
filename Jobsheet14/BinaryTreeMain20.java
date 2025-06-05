public class BinaryTreeMain20 {
    public static void main(String[] args) {
        BinaryTree20 tree = new BinaryTree20();

        // Menambahkan data mahasiswa ke dalam pohon
        tree.add(new Mahasiswa20("244160121", "Ali", "A", 3.57));
        tree.add(new Mahasiswa20("244160221", "Badar", "B", 3.85));
        tree.add(new Mahasiswa20("244160185", "Candra", "C", 3.21));
        tree.add(new Mahasiswa20("244160301", "Dian", "D", 3.65));
        tree.add(new Mahasiswa20("244160275", "Eka", "E", 2.98));

        // Menampilkan data dengan traversal inorder
        System.out.println("Data Mahasiswa (Inorder Traversal):");
        tree.traverseInOrder(tree.root);

        // Mencari mahasiswa dengan IPK tertentu
        double cariIpk = 3.85;
        boolean ditemukan = tree.find(cariIpk);
        System.out.println("\nApakah ada mahasiswa dengan IPK " + cariIpk + "? " + (ditemukan ? "Ya" : "Tidak"));

        // Menghapus mahasiswa berdasarkan IPK
        double hapusIpk = 3.21;
        System.out.println("\nMenghapus mahasiswa dengan IPK " + hapusIpk);
        tree.delete(hapusIpk);
        System.out.println("Data Mahasiswa setelah penghapusan:");
        tree.traverseInOrder(tree.root);
    }
}