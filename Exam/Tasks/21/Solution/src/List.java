public class List<T> {
    public class Link {
        T data;
        Link prev, next;

        Link(T data) {
            this.data = data;
            prev = next = null;
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

    public int countOf(T comp) {
        int count = 0;
        Link current = begin;
        while(current != null) {
            if(current.data.equals(comp)) count++;
            current = current.next;
        }
        return count;
    }

    public String toString() {
        if(begin == null) return "{EMPTY}";

        Link current = begin;
        StringBuilder answer = new StringBuilder("{ ");
        while (current.next != null) {
            answer.append(current.data).append(", ");
            current = current.next;
        }
        answer.append(current.data).append(" }");
        return answer.toString();
    }
}
