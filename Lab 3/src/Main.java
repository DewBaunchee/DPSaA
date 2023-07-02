import java.util.Scanner;

public class Main {

    public static CombQueue<String> combQueue;
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while(choose()){System.out.println();}
        System.out.println("Goodbye!");
    }

    private static boolean choose() {
        double[] d = new double[]{0.1, 0.2, 0.3, 0.05, 0.35};
        combQueue = new CombQueue<>(d);
        System.out.println("Enter action:\n1. Create new queue;\n2. Push to queue;\n3. Pop from queue;\n4. Print queue;\n5. Find element in queue;\n\"Exit\" to exit.");
        switch (in.nextLine().toLowerCase()) {
            case "1": createQueue(); return true;
            case "2": enqueue(); return true;
            case "3": dequeue(); return true;
            case "4": printQueue(); return true;
            case "5": findInQueue(); return true;
            case "exit": return false;
            default: return true;
        }
    }

    private static void findInQueue() {

    }

    private static void printQueue() {

    }

    private static void dequeue() {

    }

    private static void enqueue() {
    }

    private static void createQueue() {
    }
}

/*private static void findInQueue() {
        System.out.println("Enter element which you want to find: ");
        PQLink<String> link = queue.find(in.nextLine());
        if(link == null) {
            System.out.println("No such element in queue.");
        } else {
            System.out.println("Found element: " + link.data);
        }
    }

    private static void printQueue() {
        System.out.println("Current queue: " + queue.queueToStr());
    }

    private static void popFromQueue() {
        System.out.println("Deleted link: " + queue.popTail().data);
    }

    private static void pushToQueue() {
        System.out.println("Enter data:");
        queue.pushHead(in.nextLine());
        System.out.println("Done!");
    }

    private static void createQueue() {
        queue = new PQueue<>();
        System.out.println("Done!");
    }*/