public class BinTree {
    public class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    Node root;

    public BinTree() {
        root = null;
    }

    public void add(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }

        Node current = root;
        while (true) {
            if (current.key == key) break;

            if (key < current.key) {
                if (current.left == null) {
                    current.left = new Node(key);
                    break;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = new Node(key);
                    break;
                } else {
                    current = current.right;
                }
            }
        }
    }

    public void reverse() {
        recReverse(root);
    }

    private void recReverse(Node node) {
        if(node == null) return;

        recReverse(node.left);
        recReverse(node.right);
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public String returnSymmetricRevision() {
        if(root == null) return "{EMPTY}";

        String answer = recRevision(root);
        return "{ " + answer.substring(0, answer.length() - 2) + " }";
    }

    private String recRevision(Node node) {
        if(node == null) return "";

        return recRevision(node.left) + node.key + ", " + recRevision(node.right);
    }
}
