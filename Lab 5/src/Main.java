import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);
    public static BinTree tree = new BinTree();

    public static boolean hubChoosing() {
        System.out.println("Choose action:\n1. Create empty tree;\n2. Add element;\n3. Delete element;" +
                "\n4. Find element;\n5. Direct revision;\n6. Reverse revision;\n7. Symmetric revision;" +
                "\n8. View as tree;\n9. Print example;\n\"Exit\" to exit.");
        switch (in.nextLine().trim().toLowerCase()) {
            case "1":
                createEmptyTree();
                return true;
            case "2":
                addElement();
                return true;
            case "3":
                delete();
                return true;
            case "4":
                findElement();
                return true;
            case "5":
                directRevision();
                return true;
            case "6":
                reverseRevision();
                return true;
            case "7":
                symmetricRevision();
                return true;
            case "8":
                viewAsTree();
                return true;
            case "9":
                printExample();
                return true;
            case "exit":
                return false;
            default:
                return true;
        }
    }

    private static void printExample() {
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
        System.out.println(tree.printAsTree());
        System.out.println("Direct : " + tree.printDirectRec());
        System.out.println("Reverse : " + tree.printReverseRec());
        System.out.println("Symmetric : " + tree.printSymmetricRec());
    }

    private static void directRevision() {
        System.out.println("Direct : " + tree.printDirectRec());
    }

    private static void reverseRevision() {
        System.out.println("Reverse : " + tree.printReverseRec());
    }

    private static void symmetricRevision() {
        System.out.println("Symmetric : " + tree.printSymmetricRec());
    }

    private static void findElement() {
        System.out.println("Enter key:");
        try {
            Link link = tree.find(Integer.parseInt(in.nextLine()));
            if(link.key == -101) {
                System.out.println("Element is not found.");
            } else {
                System.out.println("Element have" + (link.left == null ? " not" : "") + " left child and have"
                        + (link.right == null ? " not" : "") + " right child.");
            }
        } catch (Exception e) {
            System.out.println("Try again.");
        }
    }

    public static void createEmptyTree() {
        tree = new BinTree();
    }

    public static void addElement() {
        System.out.println("Enter key (-101 < key < 101):");
        String errorText = "";
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

    public static void delete() {
        System.out.println("Enter key:");
        String errorText = "";
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
        System.out.println("This program imitate work with binary trees.");
        while (hubChoosing()) {
        }
        System.out.println("Goodbye!");
    }
}
