public class BinaryTree20 {
    Node20 root;

    public BinaryTree20() {
        root = null;
    }
    public boolean isEmpty() {
        return root == null;
    }

    public void add(Mahasiswa20 mahasiswa) {
        Node20 newNode = new Node20(mahasiswa);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node20 current = root;
            Node20 parent = null;
            while (true) {
                parent = current;
                if (mahasiswa.ipk < current.Mahasiswa20.ipk) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    boolean find(double ipk) {
        boolean result = false;
        Node20 current = root;
        while (current != null) {
            if (current.Mahasiswa20.ipk == ipk) {
                result = true;
                break;
            } else if (ipk > current.Mahasiswa20.ipk) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return result;
    }

    void traversePreOrder(Node20 node) {
        if (node != null) {
            node.Mahasiswa20.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traverseInOrder(Node20 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.Mahasiswa20.tampilInformasi();
            traverseInOrder(node.right);
        }
    }

    void traversePostOrder(Node20 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.Mahasiswa20.tampilInformasi();
        }
    }

    Node20 GetSuccessor(Node20 del) {
        Node20 successor = del.right;
        Node20 successorParent = del;

        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }

        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    void delete(double ipk) {
        if (isEmpty()) {
            System.out.println("Binary tree kosong.");
            return;
        }

        Node20 parent = root;
        Node20 current = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.Mahasiswa20.ipk == ipk) {
                break;
            } else if (ipk < current.Mahasiswa20.ipk) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (ipk > current.Mahasiswa20.ipk) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current == null) {
            System.out.println("Data tidak ditemukan");
            return;
        } else {
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else {
                    if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } else if (current.left == null) {
                if (current == root) {
                    root = current.right;
                } else {
                    if (isLeftChild) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
                
            } else if (current.right == null) {
                if (current == root) {
                    root = current.left;
                } else {
                    if (isLeftChild) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            } else {
                Node20 successor = GetSuccessor(current);
                System.out.println("Jika 2 anak, current = ");
                successor.Mahasiswa20.tampilInformasi();
                if (current == root) {
                    root = successor;
                } else {
                    if (isLeftChild) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                }
                successor.left = current.left;
            }
        }
    }
}