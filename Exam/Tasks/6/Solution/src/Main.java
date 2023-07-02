public class Main {

    public static void main(String[] args) {
	    BinTree t = new BinTree();
        t.add(6);
        t.add(5);
        t.add(10);
        t.add(3);
        t.add(4);
        t.add(8);
        t.add(12);
        t.add(11);
        t.add(7);
        t.add(9);
        System.out.println(t.returnDirectRevision());
        t.resew();
        System.out.println(t.returnDirectRevision());
    }
}
