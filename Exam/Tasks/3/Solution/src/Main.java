public class Main {

    public static void main(String[] args) {
        List l = new List();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.reverse();
        List a = new List();
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.reverse();
        l.addList(a);
        System.out.println(l.toString());
    }
}
