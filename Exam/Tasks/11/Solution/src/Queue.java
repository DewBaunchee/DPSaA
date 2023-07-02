public class Queue {
    public class Link {
        int key;
        Link next;

        Link(int key) {
            this.key = key;
            next = null;
        }
    }

    private Link begin, end;
    private int size;

    public Queue() {
        begin = end = null;
        size = 0;
    }

    public void push(int key) {
        if (begin == null) {
            begin = end = new Link(key);
        } else {
            end.next = new Link(key);
            end = end.next;
        }
        size++;
    }

    public void concat(Queue queue) {
        end.next = queue.begin;
    }

    public static Stack toStack(Queue q) {
        Stack first = new Stack();

        Link current = q.begin;
        while(current != null) {
            first.push(current.key);
            current = current.next;
        }
        return first;
    }

    public String toString() {
        if (begin == null) return "{EMPTY}";

        StringBuilder answer = new StringBuilder("{ ");
        Link current = begin;
        while (current.next != null) {
            answer.append(current.key).append(", ");
            current = current.next;
        }
        return answer.append(current.key).append(" }").toString();
    }
}
