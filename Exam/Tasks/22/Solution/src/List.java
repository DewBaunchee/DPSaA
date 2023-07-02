public class List {
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

    public List() {
        begin = end = null;
        size = 0;
    }

    public void add(int key) {
        if (begin == null) {
            begin = end = new Link(key);
        } else {
            end.next = new Link(key);
            end = end.next;
        }
        size++;
    }

    public void ascendAdd(int key) {
        if (begin == null) {
            begin = end = new Link(key);
        } else {
            if (key <= begin.key) {
                Link temp = new Link(key);
                temp.next = begin;
                begin = temp;
            } else {
                Link current = begin;
                while (current.next != null && key > current.next.key) {
                    current = current.next;
                }
                Link temp = new Link(key);
                temp.next = current.next;
                current.next = temp;

                if(temp.next == null) end = temp;
            }
        }
        size++;
    }

    public void ascendSort() {
        for (int i = 1; i < size; i++) {
            Link current = begin;
            Link next = begin.next;
            for (int j = 0; j < size - i; j++) {
                if (current.key > next.key) {
                    int temp = current.key;
                    current.key = next.key;
                    next.key = temp;
                }
                current = current.next;
                next = next.next;
            }
        }
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
