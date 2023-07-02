public class List {
    public class Link {
        int data;
        Link next;

        Link(int data) {
            this.data = data;
            next = null;
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
            end = end.next;
        }
    }

    public boolean contains(int data) {
        Link current = begin;
        while (current != null) {
            if(current.data == data) return true;
            current = current.next;
        }
        return false;
    }

    public void crossWith(List list) {
        Link findable = begin;

        while (findable != null) {
            if(!list.contains(findable.data)) remove(findable.data);
            findable = findable.next;
        }
    }

    private void remove(int data) {
        Link parent = null;
        Link removable = begin;

        while (removable != null && removable.data != data) {
            parent = removable;
            removable = removable.next;
        }

        if(removable == null) return;

        if(parent == null) {
            begin = removable.next;
            if(begin == null) end = null;
        } else {
            parent.next = removable.next;
            if(parent.next == null) end = parent;
        }
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
