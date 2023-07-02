import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);
    public static SewedBinaryTree tree = new SewedBinaryTree();

    public static boolean hubChoosing() {
        System.out.println("Choose action:");
        System.out.println("1. Create empty tree;");
        System.out.println("2. Add element;");
        System.out.println("3. Delete element;");
        System.out.println("4. Find element;");
        System.out.println("5. Print symmetric revision;");
        System.out.println("6. Print direct revision;");
        System.out.println("7. Print as tree;");
        System.out.println("8. Print simple example;");
        System.out.println("\"Exit\" to exit.");
        switch (in.nextLine().trim().toLowerCase()) {
            case "1":
                createEmptyTree();
                return true;
            case "2":
                addElement();
                return true;
            case "3":
                deleteElement();
                return true;
            case "4":
                findElement();
                return true;
            case "5":
                symmetricRevision();
                return true;
            case "6":
                directRevision();
                return true;
            case "7":
                viewAsTree();
                return true;
            case "8":
                printSimpleExample();
                return true;
            case "exit":
                return false;
            default:
                return true;
        }
    }

    private static void printSimpleExample() {tree = new SewedBinaryTree();
        tree.add(10);
        tree.add(4);
        tree.add(5);
        tree.add(20);
        tree.add(15);
        tree.add(16);
        tree.add(17);
        tree.add(18);
        tree.add(19);
        tree.add(22);
        tree.add(21);
        System.out.println("Direct revision : " + tree.printDirectRev());
        System.out.println("Deleting element with key equal 10...");
        tree.delete(10);
        System.out.println("Symmetric revision : " + tree.printCentralRev());
        System.out.println("Tree : \n" + tree.printAsTree());
    }

    private static void symmetricRevision() {
        System.out.println("Symmetric revision : " + tree.printCentralRev());
    }

    private static void directRevision() {
        System.out.println("Direct revision : " + tree.printDirectRev());
    }

    private static void findElement() {
        System.out.println("Enter key:");
        try {
            Link link = tree.find(Integer.parseInt(in.nextLine()));
            if (link.key == -101) {
                System.out.println("Element is not found.");
            } else {
                climbing(link);
            }
        } catch (Exception e) {
            System.out.println("Try again.");
        }
    }

    private static void climbing(Link link) {
        boolean hasNextStep = true;
        do {
            System.out.println("Element have" + (link.left == null ? " not" : "") + " left step and have"
                    + (link.right == null ? " not" : "") + " right step.");
            System.out.println("Enter 'r' for right step or 'l' for left step or 'cancel'");
            switch (in.nextLine().toLowerCase().trim()) {
                case "r":
                    link = link.right;
                    if(link == null) {
                        hasNextStep = false;
                    } else {
                        System.out.println("Right child: " + link.key);
                    }
                    break;
                case "l":
                    link = link.left;
                    if(link == null) {
                        hasNextStep = false;
                    } else {
                        System.out.println("Right child: " + link.key);
                    }
                    break;
                default:
                    hasNextStep = false;
                    break;
            }
        } while (hasNextStep);
    }

    public static void createEmptyTree() {
        tree = new SewedBinaryTree();
    }

    public static void addElement() {
        System.out.println("Enter key (-101 < key < 101):");
        String errorText;
        do {
            try {
                errorText = tree.add(Integer.parseInt(in.nextLine()));
            } catch (Exception e) {
                errorText = "Incorrect data.";
            }
            if (errorText.length() > 0) {
                System.out.println(errorText + " Try again.");
            }
        } while (errorText.length() > 0);
        System.out.println("Element added.");
    }

    public static void deleteElement() {
        System.out.println("Enter key:");
        String errorText;
        do {
            errorText = tree.delete(Integer.parseInt(in.nextLine()));
            if (errorText.length() > 0) {
                System.out.println(errorText + " Try again.");
            }
        } while (errorText.length() > 0);
        System.out.println("Element deleted.");
    }

    public static void viewAsTree() {
        System.out.println(tree.printAsTree());
    }

    public static void main(String[] args) {
        System.out.println("This program imitate work with stitched binary trees.");
        while (hubChoosing()) {System.out.println();}
        System.out.println("Goodbye!");
    }
}
