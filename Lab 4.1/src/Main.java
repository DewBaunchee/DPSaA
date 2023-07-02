import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static Stack stack = new Stack();

    public static void main(String[] args) {
        while (choose()) {
            System.out.println();
        }
        System.out.println("Goodbye!");
    }

    private static boolean choose() {
        System.out.println("Enter action:\n1. Create new stack;\n2. Push to stack;\n3. Pop from stack;\n4. Print stack;\n5. Transform expression to postfix notation;\n6. Transform expression to prefix notation;\n\"Exit\" to exit.");
        switch (in.nextLine().toLowerCase()) {
            case "1":
                createStack();
                return true;
            case "2":
                pushToStack();
                return true;
            case "3":
                popFromStack();
                return true;
            case "4":
                printStack();
                return true;
            case "5":
                transformToPost();
                return true;
            case "6":
                transformToPre();
                return true;
            case "exit":
                return false;
            default:
                return true;
        }
    }

    private static void transformToPre() {
    }

    private static void printPostfixExpression() {
        System.out.println("Enter expression:");
        System.out.println("Postfix form of entered expression: " + transformToPost(in.nextLine()));
    }

    private static String transformToPost(String exp) {
        exp = exp.replaceAll(" ", "");
        if(exp.length() == 0) {
            return "No expression";
        }

        String answer = "";
        Stack operations = new Stack();
        for(int i = 0; i < exp.length(); i++) {
            char chr = exp.charAt(i);
            if(isLetter(chr)) {
                answer = answer + chr;
                continue;
            }
            if(operations.peak == null) {
                operations.push(chr);
                continue;
            }
            if(getPriority(operations.peak.data) > getPriority(chr)) {

            }
        }
        return answer;
    }

    private static int getPriority(char operation) {
        switch (operation) {
            case '(': return 0;
            case ')': return 1;
            case '+':
            case '-': return 2;
            case '*':
            case '/': return 3;
            case '^': return 4;
            default: return -1;
        }
    }

    private static boolean isLetter(char chr) {
        return chr > 64 && chr < 91 || chr > 96 && chr < 123;
    }

    private static void printStack() {
        System.out.println("Stack: \n" + stack.toStr());
    }

    private static void popFromStack() {
        System.out.println("Popped element: " + stack.pop().data);
    }

    private static void pushToStack() {
        System.out.println("Enter element for pushing:");
        stack.push(in.nextLine());
        System.out.println("Element added.");
    }

    private static void createStack() {
        stack = new Stack();
        System.out.println("Done!");
    }
}
