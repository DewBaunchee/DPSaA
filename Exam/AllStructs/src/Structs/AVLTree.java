package Structs;

import java.util.ArrayList;

public class AVLTree {
    public class Link {
        int key;
        String data;
        Link left, right;
        int height;

        Link(int key, String data) {
            this.key = key;
            this.data = data;
            left = right = null;
            height = 1;
        }
    }

    Link root;

    public AVLTree() {
        root = null;
    }

    public void add(int key, String data) throws Exception {
        if (root == null) {
            root = new Link(key, data);
        } else {
            root = recAdd(root, key, data);
        }
    }

    private Link recAdd(Link node, int key, String data) throws Exception {
        if (node.key == key) throw new Exception("Key is already exist.");

        if (key < node.key) {

            if (node.left == null) {
                node.left = new Link(key, data);
            } else {
                node.left = recAdd(node.left, key, data);
            }

        } else {

            if (node.right == null) {
                node.right = new Link(key, data);
            } else {
                node.right = recAdd(node.right, key, data);
            }

        }

        return rebalance(node);
    }

    public Link rebalance(Link node) {
        fixHeight(node);
        if (balanceFactor(node) == 2) {
            if (balanceFactor(node.left) < 0)
                node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balanceFactor(node) == -2) {
            if (balanceFactor(node.right) > 0)
                node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private Link rightRotate(Link node) {
        Link left = node.left;
        node.left = left.right;
        left.right = node;
        fixHeight(node);
        fixHeight(left);
        return left;
    }

    private Link leftRotate(Link node) {
        Link right = node.right;
        node.right = right.left;
        right.left = node;
        fixHeight(node);
        fixHeight(right);
        return right;
    }

    public int height(Link node) {
        return node == null ? 0 : node.height;
    }

    private void fixHeight(Link node) {
        int hLeft = height(node.left);
        int hRight = height(node.right);
        node.height = Math.max(hLeft, hRight) + 1;
    }

    private int balanceFactor(Link node) {
        return height(node.left) - height(node.right);
    }
}
