import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);
    private static HashCatalog catalog = new HashCatalog(5);

    public static void main(String[] args) throws IOException {
        while (choose()) System.out.println();
    }

    private static boolean choose() throws IOException {
        System.out.println("Choose action: \n1. Create new catalog;\n2. Add record to catalog;\n3. Remove record from catalog;\n4. Find record in catalog;\n5. Print current catalog;\n6. Exit.");
        switch (in.nextLine()) {
            case "1":
                createCatalog();
                return true;
            case "2":
                addRecord();
                return true;
            case "3":
                removeRecord();
                return true;
            case "4":
                findRecord();
                return true;
            case "5":
                printCatalog();
                return true;
            case "6":
                return false;
            default:
                return true;
        }
    }

    private static void printCatalog() {
        System.out.println("Do you want to print the catalog with empty sections? [y/n]");
        switch (in.nextLine()) {
            case "y":
                System.out.println(catalog.print());
                break;
            case "n":
                System.out.println(catalog.clearPrint());
                break;
        }
    }

    private static void findRecord() {
        System.out.println("Enter word which you want to find:");
        System.out.println(catalog.find(in.nextLine()));
    }

    private static void removeRecord() {
        System.out.println("Enter word which you want to remove:");
        System.out.println(catalog.remove(in.nextLine()));
    }

    private static void addRecord() {
        System.out.println("Enter word and its description [word - description]:");
        String line = in.nextLine();
        if (line.indexOf('-') > -1) {
            line = catalog.add(line.substring(0, line.indexOf('-')), line.substring(line.indexOf('-') + 1));
            if (line.length() > 0) {
                System.out.println(line);
            } else {
                System.out.println("Element added.");
            }
        } else {
            System.out.println("Input error");
        }
    }

    // CREATING
    private static void createCatalog() throws IOException {
        System.out.println("Are you want to create empty catalog [1] or input catalog from file [2]?");
        switch (in.nextLine()) {
            case "1":
                if(createEmptyCatalog()) {
                    System.out.println("Catalog created.");
                }
                break;
            case "2":
                if(inputCatalogFromFile()) {
                    System.out.println("Catalog created.");
                }
                break;
        }
    }

    private static boolean inputCatalogFromFile() throws IOException {
        boolean invalid = true;
        System.out.println("Enter a number that will mean the number of cells in the catalog for one letter of the alphabet or \"cancel\".");
        do {
            try {
                String answer = in.nextLine();
                if(answer.equals("cancel")) {
                    return false;
                }
                catalog = new HashCatalog(Integer.parseInt(answer));
                invalid = false;
            } catch (Exception e) {
                System.out.println("Try again.");
            }
        } while (invalid);
        FileReader fr = null;
        Scanner fileScanner = null;
        invalid = true;
        System.out.println("Enter path to file or \"cancel\":");
        do {
            try {
                String answer = in.nextLine();
                if (answer.equals("cancel")) {
                    return true;
                }
                fr = new FileReader(answer);
                fileScanner = new Scanner(fr);
                invalid = false;
            } catch (Exception e) {
                System.out.println("File error");
            }
        } while (invalid);

        int counter = 0;
        try {
            while (fileScanner.hasNextLine()) {
                counter++;
                String line = fileScanner.nextLine();
                catalog.add(line.substring(0, line.indexOf('-')), line.substring(line.indexOf('-') + 1));
            }
        } catch (Exception e) {
            System.out.println("Read error, number of saved records: " + counter);
        }
        fileScanner.close();
        fr.close();
        return true;
    }

    private static boolean createEmptyCatalog() {
        boolean invalid = true;
        System.out.println("Enter a number that will mean the number of cells in the catalog for one letter of the alphabet or \"cancel\".");
        do {
            try {
                String answer = in.nextLine();
                if(answer.equals("cancel")) {
                    return false;
                }
                catalog = new HashCatalog(Integer.parseInt(answer));
                invalid = false;
            } catch (Exception e) {
                System.out.println("Try again.");
            }
        } while (invalid);
        return true;
    }
}