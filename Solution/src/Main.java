import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static List<Character> list;
    public static Scanner in  = new Scanner(System.in);
    
    public static void main(String[] args) {
        while(choose());
    }

    private static boolean choose() {
        System.out.println("Choose action:");
        System.out.println("1. Quick one;");
        System.out.println("2. Create empty list;");
        System.out.println("3. Add character;");
        System.out.println("4. Print list;");
        System.out.println("5. Solve the task;");
        System.out.println("EXIT");
        
        switch (in.nextLine().toLowerCase().trim()) {
            case "1":
                List<Character> temp = new List<>();
                temp.add('d');
                temp.add('d');
                temp.add('a');
                temp.add('u');
                temp.add('A');
                temp.add('b');
                temp.add('c');
                temp.add('c');
                System.out.println(temp);
                solveTask(temp);
                return true;
            case "2":
                list = new List<>();
                return true;
            case "3":
                try {
                    char c = in.nextLine().trim().charAt(0);
                    list.add(c);
                } catch (Exception e) {
                    System.out.println("Error.");
                }
                return true;
            case "4":
                System.out.println(list.toString());
                return true;
            case "5":
                solveTask(list);
                return true;
            case "exit":
                return false;
        }
        return true;
    }

    private static void solveTask(List<Character> list) {
        for (int i = 0; i < 26; i++) {
            int count = (list.countOf((char) ('a' + i)) + list.countOf((char) ('A' + i)));
            if (count > 0)
                System.out.println("Count of " + ((char) ('A' + i)) + "/" + ((char) ('a' + i)) + ": " + count);
        }
    }
}
