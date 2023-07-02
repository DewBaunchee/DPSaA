public class Main {

    public static void main(String[] args) {
        List l1 = new List();
        List l2 = new List();
        l1.add(1);
        l2.add(2);
        l1.crossWith(l2);
        System.out.println(l1);
    }
}
