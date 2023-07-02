public class BinTree {
    public class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }

        public String toString() {
            return key + "";
        }
    }

    Node root;

    public BinTree() {
        root = null;
    }

    public boolean add(int key) {
        if(root == null) {
            root = new Node(key);
        } else {
            Node current = root;

            while (true) {
                if(current.key == key) return false;

                if(key < current.key) {
                    if(current.left == null) {
                        current.left = new Node(key);
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    if(current.right == null) {
                        current.right = new Node(key);
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
        return true;
    }
}
