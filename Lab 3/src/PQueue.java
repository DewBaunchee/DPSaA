public class PQueue<T> {

    PQLink<T> head, tail;

    PQueue() {
        head = tail = null;
    }

    void push(int priority, T data) {
        PQLink<T> pqLink = new PQLink<>(data, priority);

        if(head == null) {
            head = tail = pqLink;
        } else {
            PQLink<T> prev = null, current = head;
            while(current.next != null) {
                if(pqLink.priority < current.priority) {
                    if(prev == null) {
                        pqLink.next = current;
                        head = pqLink;
                    }
                }
                prev = current;
                current = current.next;
            }
        }
    }
}