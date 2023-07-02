public class Main {

    public static void main(String[] args) {
        List l = new List();
        l.add(7);
        l.add(8);
        l.add(2);
        l.add(2);
        l.add(6);
        l.add(3);
        l.add(34);
        l.add(32);
        System.out.println(l);
        l.ascendSort();
        System.out.println(l);
        l.ascendAdd(6);
        System.out.println(l);
    }
}
