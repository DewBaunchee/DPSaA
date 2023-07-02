public class WQueue<T> {
    double weight;
    WQLink<T> head, tail;

    WQueue(double weight) {
        this.weight = weight;
        head = tail = null;
    }

    void pushHead(T data) {
        WQLink<T> link = new WQLink<T>(data);

        if(head == null) {
            head = tail = link;
        } else {
            link.next = head;
            head = link;
        }
    }

    WQLink popTail() {
        WQLink<T> current = head;
        if(tail == head) {
            head = tail = null;
            return current;
        }
        while(current.next != tail) {
            current = current.next;
        }
        current.next = null;
        WQLink<T> deletable = tail;
        tail = current;
        return deletable;
    }

    WQLink<T> find(String data) {
        WQLink<T> current = head;
        if(current == null) {
            return null;
        }
        while(current.next != null) {
            if(current.data.equals(data)) {
                return current;
            }
            current = current.next;
        }
        if(current.data == data) {
            return current;
        }
        return null;
    }

    String queueToStr(){
        WQLink<T> current = head;
        String answer = "Push -> { ";
        if(current == null) {
            return "Queue is empty.";
        }
        while(current.next != null){
            answer = answer + current.data + " , ";
            current = current.next;
        }
        answer = answer + current.data + " } -> Pop [Weight = " + this.weight + "]";
        return answer;
    }
}
