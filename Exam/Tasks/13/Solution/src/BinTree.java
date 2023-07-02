public class BinTree {
    public class Node {
        int key;
        Node left, right;
        boolean rTag;

        Node(int key) {
            this.key = key;
            left = right = null;
            rTag = false;
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
                if (current.right == null || current.rTag) {
                    current.right = new Node(key);
                    break;
                } else {
                    current = current.right;
                }
            }
        }
    }

    int[] counts;
    public int[] solveTask() {
        counts = new int[3];
        recSolve(root);
        return counts;
    }

    private void recSolve(Node node) {
        if(node == null) return;

        if(node.right == null && node.left != null) {
            counts[0]++;
        }
        if(node.left == null && node.right != null) {
            counts[1]++;
        }
        if(node.left != null && node.right != null) {
            counts[2]++;
        }
        recSolve(node.left);
        recSolve(node.right);
    }
}
