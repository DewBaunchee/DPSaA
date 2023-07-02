import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);
    public static Polynomial poly;

    public static void main(String[] args) {
        while (choose()) System.out.println();
    }

    private static boolean choose() {
        System.out.println("Choose action: \n1. Form list from string;\n2. Check equality of polynomials;\n3. Mean of polynomial in X;\n4. Add polynomials;\n5. Print current polynomial;\n6. Exit.");
        switch(in.nextLine()) {
            case "1": formListFromString(); return true;
            case "2": equality(); return true;
            case "3": meaning(); return true;
            case "4": add(); return true;
            case "5": printPoly(); return true;
            case "6": return false;
            default: return true;
        }
    }

    private static void printPoly() {
        System.out.println("Current polynomial: " + poly.polyToString());
    }

    private static void add() {
        System.out.println("Enter polynomial to add (example: -5x^6 + 3x^2- x + 7):");
        System.out.println("Sum of polynomials: " + poly.add(new Polynomial(in.nextLine())).polyToString());
    }

    private static void meaning() {
        System.out.println("Enter x to calculate meaning of polynomial in it: ");
        System.out.println("Meaning of polynomial in point x: " + poly.meaning(Integer.parseInt(in.nextLine())));
    }

    private static void equality() {
        System.out.println("Enter polynomial for comparing (example: -5x^6 + 3x^2- x + 7):");
        System.out.println(poly.equality(new Polynomial(in.nextLine())) ? "Polynomials are equal." : "Polynomials are not equal.");
    }

    private static void formListFromString() {
        System.out.println("Enter polynomial (example: -5x^6 + 3x^2- x + 7):");
        poly = new Polynomial(in.nextLine());
        System.out.println("Done!");
    }
}