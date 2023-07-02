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

        public boolean lesserThan(Link next) {
            return data.compareTo(next.data) < 0;
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
        if(begin == null) {
            begin = end = new Link(data);
        } else {
            end.next = new Link(data);
            end = end.next;
        }
        size++;
    }

    public void sort() {
        if(begin == end) return;

        for(int i = 1; i < size; i++) {
            Link current = begin;
            Link next = begin.next;

            for(int j = 0; j < size - i; j++) {
                if(current.lesserThan(next)) {
                    current.swapData(next);
                }
                current = next;
                next = next.next;
            }
        }
    }

    public String toString() {
        if(begin == null) return "{EMPTY}";

        Link current = begin;
        StringBuilder answer = new StringBuilder("{ ");
        while(current.next != null) {
            answer.append(current.toString()).append(", ");
            current = current.next;
        }
        return answer.append(current.toString()).append(" }").toString();
    }
}
