import java.util.Scanner;

public class BinaryTreeArrayMain20 {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BinaryTree20 tree = new BinaryTree20();

    // Menambahkan data mahasiswa dengan metode `add`
    tree.addRekursif(tree.root, new Mahasiswa20("244160121", "Ali", "A", 3.57));
tree.addRekursif(tree.root, new Mahasiswa20("244160221", "Badar", "B", 3.85));
tree.addRekursif(tree.root, new Mahasiswa20("244160185", "Candra", "C", 3.21));

    // Menampilkan data dengan traversal inorder
    System.out.println("Data Mahasiswa (Inorder Traversal):");
    tree.traverseInOrder(tree.root);
}

}