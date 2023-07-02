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

    Node previous;

    public void resew() {
        previous = null;
        recSew(root);
    }

    private void recSew(Node node) {
        if (node == null) return;

        sewNode(node);
        previous = node;
        recSew(node.left);
        if (!node.rTag)
            recSew(node.right);
    }

    private void sewNode(Node node) {
        if(previous == null) return;
        if(previous.left == node || previous.right == node) return;
        if(previous.rTag || previous.right == null) {
            previous.right = node;
            previous.rTag = true;
        }
    }

    public String returnDirectRevision() {
        if(root == null) return "{EMPTY}";

        StringBuilder answer = new StringBuilder("{ ");
        Node current = root;
        while (current.right != null) {
            while(current.left != null) {
                answer.append(current.key).append(", ");
                current = current.left;
            }
            answer.append(current.key).append(", ");
            current = current.right;
        }

        while(current.left != null) {
            answer.append(current.key).append(", ");
            current = current.left;
        }

        return answer.append(current.key).append(" }").toString();
    }
}
