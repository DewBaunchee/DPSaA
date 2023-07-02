public class Main {

    public static void main(String[] args) {
        List<Integer> l1 = new List<>();
        l1.add(4);
        l1.add(2);
        l1.add(3);
        l1.add(1);
        List<Integer> l2 = new List<>();
        l2.add(6);
        l2.add(1);
        l2.add(3);
        l2.add(2);
        l2.add(5);
        l1.sort();
        l1.addAscendingList(l2);
        System.out.println(l1);
    }
}
