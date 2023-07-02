package Structs;

public class LinkedList {
    private class Link {
        String data;
        Link next;

        Link(String data) {
            this.data = data;
            next = null;
        }
    }

    Link begin;

    public LinkedList() {
        begin = null;
    }

    public void add(String data) {
        Link link = new Link(data);

        if(begin == null) {
            begin = link;
        } else {
            Link current = begin;
            while(current.next != null) current = current.next;

            current.next = link;
        }
    }

    public void insertAfter(int index, String data) {
        Link link = new Link(data);
        Link current = begin;

        while(current != null && index > 0) {
            current = current.next;
            index--;
        }
        if(current == null) return;

        link.next = current.next;
        current.next = link;
    }

    public void remove(int index) {
        Link prev = null;
        Link current = begin;

        while(current != null && index > 0) {
            prev = current;
            current = current.next;
            index--;
        }
        if(current == null) return;

        if(prev == null) {
            begin = begin.next;
        } else {
            prev.next = current.next;
            current.next = null;
        }
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
