public class List<T> {
    public class Link {
        T data;
        Link prev, next;

        Link(T data) {
            this.data = data;
            prev = next = null;
        }

        public String toString() {
            return data.toString();
        }
    }

    private Link begin, end;

    public List() {
        begin = end = null;
    }

    public void add(T data) {
        if(begin == null) {
            begin = end = new Link(data);
        } else {
            end.next = new Link(data);
            end.next.prev = end;
            end = end.next;
        }
    }

    public int countOf(T data) {
        if(begin == null) return 0;

        Link current = begin;
        int count = 0;
        while(current != null) {
            if(current.data.equals(data)) count++;
            current = current.next;
        }
        return count;
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
