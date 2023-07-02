package Structs;

public class DblLinkedList {
    private class Link {
        String data;
        Link next, prev;

        Link(String data) {
            this.data = data;
            next = prev = null;
        }
    }

    Link begin, end;

    public DblLinkedList() {
        begin = end = null;
    }

    public void add(String data) {
        Link link = new Link(data);

        if(begin == null) {
            begin = end = link;
        } else {
            link.prev = end;
            end.next = link;
            end = link;
        }
    }

    public void remove(int index) {
        Link current = begin;

        while(current != null && index > 0) {
            current = current.next;
            index--;
        }
        if(current == null) return;

        if(current.prev == null) {
            begin = current.next;
        } else {
            current.prev.next = current.next;
        }

        if(current.next == null) {
            end = current.prev;
        } else {
            current.next.prev = current.prev;
        }
    }

    public int find(String findable) {
        Link current = begin;
        int index = 0;

        while(current != null) {
            if(current.data.equals(findable)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public String toString() {
        if(begin == null) return "{ EMPTY }";
        StringBuilder ans = new StringBuilder("{ ");
        Link current = begin;

        while(current.next != null) {
            ans.append(current.data).append(", ");
            current = current.next;
        }
        ans.append(current.data).append(" }");
        return ans.toString();
    }
}
