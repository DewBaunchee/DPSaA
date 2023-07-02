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

    public int countOnLevel(int level) {
        return recCount(root, level, 1);
    }

    private int recCount(Node node, int breakLevel, int currentLevel) {
        if(node == null) {
            return 0 ;
        }
        if(currentLevel == breakLevel) {
            return 1;
        }
        return recCount(node.left, breakLevel, currentLevel + 1) + recCount(node.right, breakLevel, currentLevel + 1);
    }
}
