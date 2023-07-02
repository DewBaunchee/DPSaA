public class Main {

    public static void main(String[] args) {
        Queue q1 = new Queue();
        Queue q2 = new Queue();
        q1.push(2);
        q1.push(1);
        q1.push(3);
        q1.push(4);
        System.out.println(q1);
        q2.push(7);
        q2.push(1);
        q2.push(5);
        q2.push(8);
        q2.push(6);
        System.out.println(q2);
        q1.concat(q2);
        System.out.println(q1);
        System.out.println(Queue.toStack(q1));
    }
}
