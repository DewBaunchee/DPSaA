public class Queue<T> {
    public class Link {
        T data;
        Link next;

        Link(T data) {
            this.data = data;
            next = null;
        }
    }

    private Link begin, end;
    private int size;

    public Queue() {
        begin = end = null;
        size = 0;
    }

    public void push(T data) {
        if (begin == null) {
            begin = end = new Link(data);
        } else {
            end.next = new Link(data);
            end = end.next;
        }
        size++;
    }

    public T pop() {
        if(begin == null) return null;

        T returnable = begin.data;
        if(begin == end) {
            begin = end = null;
        } else {
            begin = begin.next;
        }
        return returnable;
    }

    public int size() {
        return size;
    }

    public String toString() {
        if (begin == null) return "{EMPTY}";

        StringBuilder answer = new StringBuilder("PUSH -> { ");
        Link current = begin;
        while (current.next != null) {
            answer.append(current.data).append(", ");
            current = current.next;
        }
        return answer.append(current.data).append(" } -> POP").toString();
    }
}
