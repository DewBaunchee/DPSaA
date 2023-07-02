public class Main {

    public static void main(String[] args) {
        Queue q = new Queue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        q.push(6);
        q.push(7);
        System.out.println(q);
        q.descendSort();
        System.out.println(q);
        q.descendPush(4);
        System.out.println(q);
    }
}
