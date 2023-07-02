public class List<T extends Comparable<T>> {
    public class Link {
        T data;
        Link next;

        Link(T data) {
            this.data = data;
            next = null;
        }

        public String toString() {
            return data.toString();
        }

        public boolean biggerThan(Link comp) {
            return data.compareTo(comp.data) > 0;
        }

        public boolean biggerThan(T comp) {
            return data.compareTo(comp) > 0;
        }

        public boolean lesserThan(Link comp) {
            return data.compareTo(comp.data) < 0;
        }

        public boolean lesserThan(T comp) {
            return data.compareTo(comp) < 0;
        }

        public void swapData(Link next) {
            T temp = next.data;
            next.data = this.data;
            this.data = temp;
        }
    }

    private Link begin, end;
    private int size;

    public List() {
        begin = end = null;
        size = 0;
    }

    public void add(T data) {
        if (begin == null) {
            begin = end = new Link(data);
        } else {
            end.next = new Link(data);
            end = end.next;
        }
        size++;
    }

    public void ascendingAdd(T data) {
        if (begin == null) {
            begin = end = new Link(data);
        } else {
            Link current = begin;
            if (current.biggerThan(data)) {
                begin = new Link(data);
                begin.next = current;
            } else {
                while(current.next != null && current.next.lesserThan(data)) {
                    current = current.next;
                }
                Link newLink = new Link(data);
                newLink.next = current.next;
                current.next = newLink;

                if(newLink.next == null) end = newLink;
            }
        }
    }

    public void addAscendingList(List<T> list) {
        Link current = list.begin;
        while(current != null) {
            ascendingAdd(current.data);
            current = current.next;
        }
    }

    public void sort() {
        if (begin == end) return;

        for (int i = 1; i < size; i++) {
            Link current = begin;
            Link next = begin.next;

            for (int j = 0; j < size - i; j++) {
                if (current.biggerThan(next)) {
                    current.swapData(next);
                }
                current = next;
                next = next.next;
            }
        }
    }

    public String toString() {
        if (begin == null) return "{EMPTY}";

        Link current = begin;
        StringBuilder answer = new StringBuilder("{ ");
        while (current.next != null) {
            answer.append(current.toString()).append(", ");
            current = current.next;
        }
        return answer.append(current.toString()).append(" }").toString();
    }
}
