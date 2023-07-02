public class List {
    public class Link {
        int data;
        Link prev, next;

        Link(int data) {
            this.data = data;
            prev = next = null;
        }
    }

    private Link begin, end;

    public List() {
        begin = end = null;
    }

    public void add(int data) {
        if(begin == null) {
            begin = end = new Link(data);
        } else {
            end.next = new Link(data);
            end.next.prev = end;
            end = end.next;
        }
    }

    public void addList(List addable) {
        end.next = addable.begin;
        addable.begin.prev = end;
    }

    public void reverse() {
        if(begin == end) return;
        Link current = begin;
        begin = end;
        end = current;
        Link next = current.next;
        while (next != null) {
            current.prev = next;
            Link temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }
        end.next = null;
        begin.prev = null;
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
