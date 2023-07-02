import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);
    public static List list = new List();

    public static void main(String[] args) {
        System.out.println("This program provides creating of list of students and printing student's average mark with no '2'");
        while(choose());
    }

    private static boolean choose() {
        System.out.println("Choose action:");
        System.out.println("1. Add record;");
        System.out.println("2. Print list;");
        System.out.println("3. Solve task.");
        System.out.println("EXIT");

        switch (in.nextLine().toLowerCase()) {
            case "1":
                addRecord();
                return true;
            case "2":
                System.out.println(list.toString());
                return true;
            case "3":
                solveTask();
                return true;
            case "exit":
                return false;
        }

        return true;
    }

    private static void solveTask() {
        List taskList = new List();
        List.Enumerator e = list.getEnumerator();

        while(e.hasNext()) {
            List.Link.Student next = e.getNext();
            if(next.mark1 != 2 && next.mark2 != 2 && next.mark3 != 2) {
                taskList.add(next.name, (next.mark1 + next.mark2 + next.mark3) / 3, 0, 0);
            }
        }
        taskList.sortByName();
        System.out.println(taskList.toString());
    }

    private static void addRecord() {
        System.out.println("Enter:\n[student's name]\n[first mark]\n[second mark]\n[third mark]");
        list.add(in.nextLine(), Double.parseDouble(in.nextLine()), Double.parseDouble(in.nextLine()), Double.parseDouble(in.nextLine()));
    }
}
/*
1
aa
2
3
4
1
ab
5
6
7
1
aa
4
5
3
1
a
4
5
3
2
3

 */