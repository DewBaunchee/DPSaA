import java.io.File;
import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);
    public static Graph<String> graph = new Graph<>("");

    public static void main(String[] args) {
        System.out.println("This program provides manipulations with organized graphs.");
        while (choose()) {
            System.out.println();
        }
        System.out.println("Goodbye!");
    }

    private static boolean choose() {
        System.out.println("Choose action:");
        System.out.println("1. Create graph;");
        System.out.println("2. Add node;");
        System.out.println("3. Remove node;");
        System.out.println("4. Link nodes;");
        System.out.println("5. Print adjacency list;");
        System.out.println("6. Print main characteristics;");
        System.out.println("7. Assign data;");
        System.out.println("8. Print data;");
        System.out.println("9. Print example;");
        System.out.println("\"Exit\" to exit.");
        switch (in.nextLine().toLowerCase().trim()) {
            case "1":
                createGraph();
                return true;
            case "2":
                addNode();
                return true;
            case "3":
                removeNode();
                return true;
            case "4":
                linkNodes();
                return true;
            case "5":
                printAdjacencyList();
                return true;
            case "6":
                printMainCharacteristics();
                return true;
            case "7":
                assignData();
                return true;
            case "8":
                printData();
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
        Graph<String> g = new Graph<>("1 d 5, 3, 6\n" +
                "2 : 1, 5, 4\n" +
                "3 : 1, 3\n" +
                "4 n \n" +
                "5 : 2\n" +
                "6 : 5, 3, 1\n", "");
        System.out.println(g.printAdjList());
        System.out.println(g.printMainCharacteristics(6, 3));
        System.out.println("Removing node 2...");
        g.remove(2);
        System.out.println(g.printAdjList());
        System.out.println(g.printMainCharacteristics(6, 3));
    }

    private static void printData() {
        System.out.println(graph.getData());
    }

    private static void assignData() {
        try {
            System.out.println("Enter node tag:");
            int order = Integer.parseInt(in.nextLine());
            System.out.println("Enter data:");
            String data = in.nextLine();

            String errorText = graph.assignData(order, data);

            if(errorText.length() > 0) {
                System.out.println(errorText);
            } else {
                System.out.println("Success!");
            }
        } catch (Exception e) {
            System.out.println("Input error.");
        }

    }

    private static void printAdjacencyList() {
        System.out.println(graph.printAdjList());
    }

    private static void addNode() {
        System.out.println("Enter node tag and adjacency list if you want:");
        try {
            graph.add(in.nextLine());
        } catch (Exception e) {
            System.out.println("Input error.");
        }
    }

    private static void removeNode() {
        System.out.println("Enter node tag which you want to remove:");
        try {
            if(graph.remove(Integer.parseInt(in.nextLine())) == null) {
                System.out.println("Node not found");
            } else {
                System.out.println("Success!");
            }
        } catch (Exception e) {
            System.out.println("Input error.");
        }
    }

    private static void linkNodes() {
        try {
            System.out.println("Enter tag of source node:");
            int src = Integer.parseInt(in.nextLine());
            System.out.println("Enter tag of destination node:");
            int dest = Integer.parseInt(in.nextLine());

            String errorText = graph.link(src, dest);

            if(errorText.length() > 0) {
                System.out.println(errorText);
            } else {
                System.out.println("Success!");
            }
        } catch (Exception e) {
            System.out.println("Input error.");
        }
    }

    private static void printMainCharacteristics() {
        try {
            System.out.println("Enter tag of source node:");
            int src = Integer.parseInt(in.nextLine());
            System.out.println("Enter tag of destination node:");
            int dest = Integer.parseInt(in.nextLine());

            System.out.println(graph.printMainCharacteristics(src, dest));
        } catch (Exception e) {
            System.out.println("Input error.");
        }
    }

    private static void createGraph() {
        System.out.println("1. Create empty;");
        System.out.println("2. Create from list in console;");
        System.out.println("3. Create from list in file;");
        switch (in.nextLine().trim()) {
            case "1":
                graph = new Graph<>("");
                break;
            case "2":
                graph = createFromConsole();
                System.out.println(graph.printAdjList());
                break;
            case "3":
                graph = createFromFile();
                System.out.println(graph.printAdjList());
                System.out.println(graph.listToString(graph.remove(1)));
                break;
        }
    }

    private static Graph<String> createFromFile() {
        System.out.println("Enter path to file with adjacency list:");
        try {
            File opFile = new File(in.nextLine());
            Scanner fc = new Scanner(opFile);
            String adjList = "";

            while (fc.hasNextLine()) {
                adjList = adjList + fc.nextLine() + "\n";
            }

            return new Graph<>(adjList);
        } catch (Exception e) {
            System.out.println("Unknown file error.");
        }
        return graph;
    }

    private static Graph<String> createFromConsole() {
        String adjList = "";
        System.out.println("Enter every line of the list as [src : [dest1, dest2, ...]] and then \"Create\" to create graph.");

        String nextLine = in.nextLine().toLowerCase();
        while (!nextLine.equals("create")) {
            adjList = adjList + nextLine + "\n";
            nextLine = in.nextLine().toLowerCase();
        }
        return new Graph<>(adjList);
    }
}
