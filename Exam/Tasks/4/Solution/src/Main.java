import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = readArray();
        printDublicates(array);
    }

    private static void printDublicates(int[] array) {
        BinTree tree = new BinTree();

        for(int i = 0; i < array.length; i++) {
            if(!tree.add(array[i])) System.out.println("Duplicate: " + array[i]);
        }
    }

    private static int[] readArray() {
        System.out.println("Enter array length:");
        int[] answer = new int[Integer.parseInt(in.nextLine())];

        for(int i = 0; i < answer.length; i++) {
            System.out.println((i + 1) + ": ");
            answer[i] = Integer.parseInt(in.nextLine());
        }

        return answer;
    }
}
