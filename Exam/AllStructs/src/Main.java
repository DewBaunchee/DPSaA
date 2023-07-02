import Structs.*;

import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (choose()) ;
    }

    private static boolean choose() {
        System.out.println("+------------------------------------+");
        System.out.println("1. Linked list [list];");
        System.out.println("2. Double linked list [dlist];");
        System.out.println("3. Queue [q];");
        System.out.println("4. Stack [s];");
        System.out.println("5. Binary tree [bin];");
        System.out.println("6. Sewed tree [sew];");
        System.out.println("7. Huffman's tree [htree];");
        System.out.println("8. AVL-tree [avl];");
        System.out.println("9. Red-black tree [rbtree];");
        System.out.println("10. Graph [graph];");
        System.out.println("11. B-tree [btree];");
        System.out.println("EXIT");
        System.out.println("+------------------------------------+");

        switch (in.nextLine().toLowerCase()) {
            case "1":
            case "list":
                llist = new LinkedList();
                while (listChoose()) ;
                return true;
            case "2":
            case "dlist":
                dlist = new DblLinkedList();
                while (dblListChoose()) ;
                return true;
            case "3":
            case "q":
                queue = new Queue();
                while (queueChoose()) ;
                return true;
            case "4":
            case "s":
                stack = new Stack<>();
                while (stackChoose()) ;
                return true;
            case "5":
            case "bin":
                binTree = new BinaryTree();
                while (binaryTreeChoose()) ;
                return true;
            case "6":
            case "sew":
                while (sewedTreeChoose()) ;
                return true;
            case "7":
            case "htree":
                while (huffmansTreeChoose()) ;
                return true;
            case "8":
            case "avl":
                while (AVLTreeChoose()) ;
                return true;
            case "9":
            case "rbtree":
                while (redBlackChoose()) ;
                return true;
            case "10":
            case "graph":
                while (graphChoose()) ;
                return true;
            case "11":
            case "btree":
                while (bTreeChoose()) ;
                return true;
            case "exit":
                return false;
        }
        return true;
    }

    private static boolean graphChoose() {
        System.out.println("+--------------------------+");
        System.out.println("1. Linked list [list];");
        System.out.println("2. Double linked list [dlist];");
        System.out.println("3. Queue [q];");
        System.out.println("4. Stack [s];");
        System.out.println("5. Binary tree [bin];");
        System.out.println("6. Sewed tree [sew];");
        System.out.println("7. Huffman's tree [htree];");
        System.out.println("8. AVL-tree [avl];");
        System.out.println("9. Red-black tree [rbtree];");
        System.out.println("10. Graph [graph];");
        System.out.println("11. B-tree [btree];");
        System.out.println("EXIT");
        System.out.println("+--------------------------+");
        return true;
    }

    private static boolean bTreeChoose() {
        System.out.println("+--------------------------+");
        System.out.println("1. Linked list [list];");
        System.out.println("2. Double linked list [dlist];");
        System.out.println("3. Queue [q];");
        System.out.println("4. Stack [s];");
        System.out.println("5. Binary tree [bin];");
        System.out.println("6. Sewed tree [sew];");
        System.out.println("7. Huffman's tree [htree];");
        System.out.println("8. AVL-tree [avl];");
        System.out.println("9. Red-black tree [rbtree];");
        System.out.println("10. Graph [graph];");
        System.out.println("11. B-tree [btree];");
        System.out.println("EXIT");
        System.out.println("+--------------------------+");
        return true;
    }

    private static boolean redBlackChoose() {
        System.out.println("+--------------------------+");
        System.out.println("1. Linked list [list];");
        System.out.println("2. Double linked list [dlist];");
        System.out.println("3. Queue [q];");
        System.out.println("4. Stack [s];");
        System.out.println("5. Binary tree [bin];");
        System.out.println("6. Sewed tree [sew];");
        System.out.println("7. Huffman's tree [htree];");
        System.out.println("8. AVL-tree [avl];");
        System.out.println("9. Red-black tree [rbtree];");
        System.out.println("10. Graph [graph];");
        System.out.println("11. B-tree [btree];");
        System.out.println("EXIT");
        System.out.println("+--------------------------+");

        return true;
    }

    private static boolean AVLTreeChoose() {
        System.out.println("+--------------------------+");
        System.out.println("1. Linked list [list];");
        System.out.println("2. Double linked list [dlist];");
        System.out.println("3. Queue [q];");
        System.out.println("4. Stack [s];");
        System.out.println("5. Binary tree [bin];");
        System.out.println("6. Sewed tree [sew];");
        System.out.println("7. Huffman's tree [htree];");
        System.out.println("8. AVL-tree [avl];");
        System.out.println("9. Red-black tree [rbtree];");
        System.out.println("10. Graph [graph];");
        System.out.println("11. B-tree [btree];");
        System.out.println("EXIT");
        System.out.println("+--------------------------+");
        return true;
    }

    private static boolean huffmansTreeChoose() {
        System.out.println("+--------------------------+");
        System.out.println("1. Linked list [list];");
        System.out.println("2. Double linked list [dlist];");
        System.out.println("3. Queue [q];");
        System.out.println("4. Stack [s];");
        System.out.println("5. Binary tree [bin];");
        System.out.println("6. Sewed tree [sew];");
        System.out.println("7. Huffman's tree [htree];");
        System.out.println("8. AVL-tree [avl];");
        System.out.println("9. Red-black tree [rbtree];");
        System.out.println("10. Graph [graph];");
        System.out.println("11. B-tree [btree];");
        System.out.println("EXIT");
        System.out.println("+--------------------------+");
        return true;
    }

    private static boolean sewedTreeChoose() {
        System.out.println("+--------------------------+");
        System.out.println("1. Linked list [list];");
        System.out.println("2. Double linked list [dlist];");
        System.out.println("3. Queue [q];");
        System.out.println("4. Stack [s];");
        System.out.println("5. Binary tree [bin];");
        System.out.println("6. Sewed tree [sew];");
        System.out.println("7. Huffman's tree [htree];");
        System.out.println("8. AVL-tree [avl];");
        System.out.println("9. Red-black tree [rbtree];");
        System.out.println("10. Graph [graph];");
        System.out.println("11. B-tree [btree];");
        System.out.println("EXIT");
        System.out.println("+--------------------------+");
        return true;
    }

    public static BinaryTree binTree;
    private static boolean binaryTreeChoose() {
        System.out.println("+--------------------------+");
        System.out.println("1. Add [add];");
        System.out.println("2. Remove [remove];");
        System.out.println("3. Find [find];");
        System.out.println("4. Direct  [dir];");
        System.out.println("5. Reverse [rev];");
        System.out.println("6. Symmetric [sym];");
        System.out.println("EXIT");
        System.out.println("+--------------------------+");
        binTree.add(10, "v");
        binTree.add(10, "v");
        binTree.add(11, "v");
        binTree.add(16, "v");
        binTree.add(15, "v");
        binTree.add(14, "v");
        binTree.add(12, "v");
        binTree.add(13, "v");
        binTree.add(17, "v");
        binTree.add(18, "v");
        binTree.add(7, "v");
        binTree.add(8, "v");
        switch (in.nextLine().toLowerCase()) {
            case "1":
            case "add":
                System.out.println("Key, \nData:");
                System.out.println(binTree.add(Integer.parseInt(in.nextLine()), in.nextLine()));
                System.out.println(binTree.printAsTree());
                return true;
            case "2":
            case "remove":
                System.out.println("Key:");
                System.out.println(binTree.remove(Integer.parseInt(in.nextLine())));
                System.out.println(binTree.printAsTree());
                return true;
            case "3":
            case "find":
                System.out.println("Key:");
                System.out.println(binTree.find(Integer.parseInt(in.nextLine())));
                System.out.println(binTree.printAsTree());
                return true;
            case "4":
            case "dir":
                System.out.println("Direct: ");
                System.out.println(binTree.printDirectRec());
                return true;
            case "5":
            case "rev":
                System.out.println("Reverse: ");
                System.out.println(binTree.printReverseRec());
                return true;
            case "6":
            case "sym":
                System.out.println("Symmetric: ");
                System.out.println(binTree.printSymmetricRec());
                return true;
            case "exit":
                return false;
        }
        return true;
    }

    public static Stack<String> stack;
    private static boolean stackChoose() {
        System.out.println("+--------------------------+");
        System.out.println("1. Push [push];");
        System.out.println("2. Pop [pop];");
        System.out.println("3. Transform expression [trans];");
        System.out.println("EXIT");
        System.out.println("+--------------------------+");

        switch (in.nextLine().toLowerCase()) {
            case "1":
            case "add":
                System.out.println("Data:");
                stack.push(in.nextLine());
                System.out.println(stack);
                return true;
            case "2":
            case "remove":
                System.out.println(stack.pop());
                System.out.println(stack);
            case "3":
            case "trans":
                /*
                a+(f-b*c/(z-x)+y)/(a*r-k)
                +a/+-f/*bc-zxy-*ark
                afbc*zx-/-y+ar*k-/+
                 */
                System.out.println("Enter expression: ");
                System.out.println(Stack.transform(in.nextLine()));
                return true;
            case "exit":
                return false;
        }
        return true;
    }

    public static Queue queue;
    private static boolean queueChoose() {
        System.out.println("+--------------------------+");
        System.out.println("1. Add [add];");
        System.out.println("2. Remove [remove];");
        System.out.println("EXIT");
        System.out.println("+--------------------------+");

        switch (in.nextLine().toLowerCase()) {
            case "1":
            case "add":
                System.out.println("Data:");
                queue.add(in.nextLine());
                System.out.println(queue);
                return true;
            case "2":
            case "remove":
                System.out.println(queue.remove());
                System.out.println(queue);
                return true;
            case "exit":
                return false;
        }
        return true;
    }

    public static DblLinkedList dlist;
    private static boolean dblListChoose() {
        System.out.println("+--------------------------+");
        System.out.println("1. Add [add];");
        System.out.println("2. Remove [remove];");
        System.out.println("3. Find [find];");
        System.out.println("EXIT");
        System.out.println("+--------------------------+");

        switch (in.nextLine().toLowerCase()) {
            case "1":
            case "add":
                System.out.println("Data:");
                dlist.add(in.nextLine());
                System.out.println(dlist.toString());
                return true;
            case "2":
            case "remove":
                System.out.println("Index:");
                dlist.remove(Integer.parseInt(in.nextLine()));
                System.out.println(dlist.toString());
                return true;
            case "3":
            case "find":
                System.out.println("Data:");
                System.out.println(dlist.find(in.nextLine()));
                return true;
            case "exit":
                return false;
        }
        return true;
    }

    public static LinkedList llist;
    private static boolean listChoose() {
        System.out.println("+--------------------------+");
        System.out.println("1. Add [add];");
        System.out.println("2. Remove [remove];");
        System.out.println("3. Insert after [insert];");
        System.out.println("EXIT");
        System.out.println("+--------------------------+");

        switch (in.nextLine().toLowerCase()) {
            case "1":
            case "add":
                System.out.println("Data:");
                llist.add(in.nextLine());
                System.out.println(llist.toString());
                return true;
            case "2":
            case "remove":
                System.out.println("Index:");
                llist.remove(Integer.parseInt(in.nextLine()));
                System.out.println(llist.toString());
                return true;
            case "3":
            case "insert":
                System.out.println("Index,\nData:");
                llist.insertAfter(Integer.parseInt(in.nextLine()), in.nextLine());
                System.out.println(llist.toString());
                return true;
            case "exit":
                return false;
        }
        return true;
    }
}
